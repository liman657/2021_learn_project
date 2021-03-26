package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * 为了清晰展现redisson操作数据方式，这里不严格按照三层模式来组织代码，这里直接引入mapper
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonMapObjectController {

    private static final String BUCKET_USER_INFO_KEY = "Redisson:Bucket:User:";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/map/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse mapAddUser(@RequestBody User user) {
        log.info("map add user info");
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {

            int res = userMapper.insertSelective(user);
            if (0 < res) {
                RMap<String, User> rMap = redissonClient.getMap(RedisKeyConstant.REDISSON_ORDINAL_MAP_KEY);
                rMap.put(String.valueOf(user.getId()), user);
            }

        } catch (Exception e) {
            log.error("map add user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/map/get", method = RequestMethod.GET)
    public BaseResponse mapGetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},map get user info", userId);
        if (userId == null || userId <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            RMap<String, User> rMap = redissonClient.getMap(RedisKeyConstant.REDISSON_ORDINAL_MAP_KEY);
            User cacheUserInfo = rMap.get(String.valueOf(userId));
            response.setData(cacheUserInfo);
            log.info("缓存中读取的user信息为:{}",cacheUserInfo);
        } catch (Exception e) {
            log.error("map get user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/map/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse mapUpdateUser(@RequestBody User user) {
        log.info("map update user info");
        if (user.getId() == null || user.getId() <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            int res = userMapper.updateByPrimaryKey(user);
            if (0 < res) {
                RMap<String, User> rMap = redissonClient.getMap(RedisKeyConstant.REDISSON_ORDINAL_MAP_KEY);
                rMap.put(String.valueOf(user.getId()), user);//简单的更新，操作和Java中的map几乎一样

                //异步的更新map
//                rMap.fastPut(user.getId(),user);
            }
        } catch (Exception e) {
            log.error("更新用户数据出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/map/delete", method = RequestMethod.GET)
    public BaseResponse mapDeletetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},map delete user info", userId);
        if (userId == null || userId <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            int res = userMapper.deleteByPrimaryKey(userId);
            if (0 < res) {
                RMap<String, User> rMap = redissonClient.getMap(RedisKeyConstant.REDISSON_ORDINAL_MAP_KEY);
                rMap.remove(String.valueOf(userId));//删除的操作，和JavaSE中的map几乎一样
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
