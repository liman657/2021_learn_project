package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * 为了清晰展现redisson操作数据方式，这里不严格按照三层模式来组织代码，这里直接引入mapper
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonLocalCacheMapObjectController {

    private static final String BUCKET_USER_INFO_KEY = "Redisson:Bucket:User:";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;

    //本地缓存映射的选项配置
    private LocalCachedMapOptions options;

    /**
     * 初始化localCacheMap
     */
    @PostConstruct
    public void initLocalCacheMap(){
        options = LocalCachedMapOptions.defaults()
                // 用于淘汰清除本地缓存内的元素
                // 共有以下几种选择:
                // LFU - 统计元素的使用频率，淘汰用得最少（最不常用）的。
                // LRU - 按元素使用时间排序比较，淘汰最早（最久远）的。
                // SOFT - 元素用Java的WeakReference来保存，缓存元素通过GC过程清除。
                // WEAK - 元素用Java的SoftReference来保存, 缓存元素通过GC过程清除。
                // NONE - 永不淘汰清除缓存元素。
                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.NONE)
                // 如果缓存容量值为0表示不限制本地缓存容量大小
                .cacheSize(1000)
                // 以下选项适用于断线原因造成了未收到本地缓存更新消息的情况。
                // 断线重连的策略有以下几种：
                // CLEAR - 如果断线一段时间以后则在重新建立连接以后清空本地缓存
                // LOAD - 在服务端保存一份10分钟的作废日志
                //        如果10分钟内重新建立连接，则按照作废日志内的记录清空本地缓存的元素
                //        如果断线时间超过了这个时间，则将清空本地缓存中所有的内容
                // NONE - 默认值。断线重连时不做处理。
                .reconnectionStrategy(LocalCachedMapOptions.ReconnectionStrategy.NONE)
                // 以下选项适用于不同本地缓存之间相互保持同步的情况
                // 缓存同步策略有以下几种：
                // INVALIDATE - 默认值。当本地缓存映射的某条元素发生变动时，同时驱逐所有相同本地缓存映射内的该元素
                // UPDATE - 当本地缓存映射的某条元素发生变动时，同时更新所有相同本地缓存映射内的该元素
                // NONE - 不做任何同步处理
                .syncStrategy(LocalCachedMapOptions.SyncStrategy.INVALIDATE)
                // 每个Map本地缓存里元素的有效时间，默认毫秒为单位
                .timeToLive(10000)
                // 或者
                .timeToLive(10, TimeUnit.SECONDS)
                // 每个Map本地缓存里元素的最长闲置时间，默认毫秒为单位
                .maxIdle(10000)
                // 或者
                .maxIdle(10, TimeUnit.SECONDS);
    }

    @RequestMapping(value = "/localCacheMap/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse localCacheMapAddUser(@RequestBody User user) {
        log.info("localCacheMap add user info");
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {

            int res = userMapper.insertSelective(user);
            if (0 < res) {
                RMap<Integer, User> rLocalCacheMap = redissonClient.getLocalCachedMap(RedisKeyConstant.REDISSON_LOCAL_CACHE_MAP_KEY,options);
                rLocalCacheMap.put(user.getId(), user);
            }

        } catch (Exception e) {
            log.error("localCacheMap add user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/localCacheMap/get", method = RequestMethod.GET)
    public BaseResponse localCacheMapGetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},localCacheMap get user info", userId);
        if (userId == null || userId <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            RMap<Integer, User> rLocalCacheMap = redissonClient.getLocalCachedMap(RedisKeyConstant.REDISSON_LOCAL_CACHE_MAP_KEY,options);
            User cacheUserInfo = rLocalCacheMap.get(userId);
            response.setData(cacheUserInfo);
            log.info("缓存中读取的user信息为:{}",cacheUserInfo);
        } catch (Exception e) {
            log.error("localCacheMap get user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/localCacheMap/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse localCacheMapUpdateUser(@RequestBody User user) {
        log.info("localCacheMap update user info");
        if (user.getId() == null || user.getId() <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            int res = userMapper.updateByPrimaryKey(user);
            if (0 < res) {
                RMap<Integer, User> rLocalCacheMap = redissonClient.getLocalCachedMap(RedisKeyConstant.REDISSON_LOCAL_CACHE_MAP_KEY,options);
                rLocalCacheMap.put(user.getId(), user);//简单的更新，操作和Java中的map几乎一样

                //异步的更新localCacheMap
//                rMap.fastPut(user.getId(),user);
            }
        } catch (Exception e) {
            log.error("更新用户数据出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/localCacheMap/delete", method = RequestMethod.GET)
    public BaseResponse localCacheMapDeletetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},localCacheMap delete user info", userId);
        if (userId == null || userId <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            int res = userMapper.deleteByPrimaryKey(userId);
            if (0 < res) {
                RMap<Integer, User> rLocalCacheMap = redissonClient.getLocalCachedMap(RedisKeyConstant.REDISSON_LOCAL_CACHE_MAP_KEY,options);
                rLocalCacheMap.remove(userId);//删除的操作，和JavaSE中的map几乎一样
                //异步删除
//                rMap.fastRemove(userId);
            }
        } catch (Exception e) {
            log.error("删除数据出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

}
