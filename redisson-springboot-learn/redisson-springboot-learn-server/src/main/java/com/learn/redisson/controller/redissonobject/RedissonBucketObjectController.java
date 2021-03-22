package com.learn.redisson.controller.redissonobject;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
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
@RequestMapping("/distobj")
@RestController
public class RedissonBucketObjectController {

    private static final String BUCKET_USER_INFO_KEY = "Redisson:Bucket:User:";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/bucket/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse bucketAddUser(@RequestBody User user) {
        log.info("bucket add user info");
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            int res = userMapper.insert(user);
            if (0 < res) {
                //插入成功，直接更新redisson
                RBucket<User> bucket = redissonClient.getBucket(BUCKET_USER_INFO_KEY + "_" + user.getId());
                bucket.set(user);
            }
            log.info("用户:{},用户数据存入成功", user.getId());
        } catch (Exception e) {
            log.error("bucket add user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/bucket/get", method = RequestMethod.GET)
    public BaseResponse bucketGetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},bucket get user info",userId);
        if (userId == null || userId <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {

            RBucket<User> bucket = redissonClient.getBucket(BUCKET_USER_INFO_KEY + "_" + userId);
            User userInfo = bucket.get();
            response.setData(userInfo);
            log.info("用户:{},读取的数据为", userInfo);
        } catch (Exception e) {
            log.error("bucket get user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/bucket/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse bucketUpdateUser(@RequestBody User user) {
        log.info("bucket update user info");
        if (user.getId()==null || user.getId()<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //TODO:先更新数据库，然后再更新缓存
            int res = userMapper.updateByPrimaryKey(user);
            if (0 < res) {
                //插入成功，直接更新redisson
                RBucket<User> bucket = redissonClient.getBucket(BUCKET_USER_INFO_KEY + "_" + user.getId());
                bucket.set(user);
            }
            log.info("用户:{},用户数据更新成功", user.getId());
        } catch (Exception e) {
            log.error("更新用户数据出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/bucket/delete", method = RequestMethod.GET)
    public BaseResponse bucketDeletetUserInfo(@RequestParam Integer userId) {
        log.info("userId:{},bucket delete user info",userId);
        if (userId==null || userId<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //TODO:先删除数据库 ~ 再删缓存
            int res=userMapper.deleteByPrimaryKey(userId);
            //直接更新redisson，这里指定类型，就不用强转了
            if(0<res) {
                RBucket<User> bucket = redissonClient.getBucket(BUCKET_USER_INFO_KEY + "_" + userId);
                bucket.delete();
            }
            log.info("用户:{}, 数据已删除", userId);
        } catch (Exception e) {
            log.error("删除数据出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

}
