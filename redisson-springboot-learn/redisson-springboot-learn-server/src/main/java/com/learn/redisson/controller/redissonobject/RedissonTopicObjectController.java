package com.learn.redisson.controller.redissonobject;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import com.learn.redisson.server.IRedissonTopicObjService;
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
 * Topic实例 订阅分发，异步实时分发邮件
 */
@Slf4j
@RequestMapping("/distobj")
@RestController
public class RedissonTopicObjectController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private IRedissonTopicObjService redissonTopicObjService;

    @RequestMapping(value = "/topic/send",method = RequestMethod.GET)
    public BaseResponse topicAddUser(@RequestParam Integer userId) {
        log.info("topic add user info");
        if (userId==null || userId<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            redissonTopicObjService.sendTopicEmail(userId);
        } catch (Exception e) {
            log.error("topic add user info 出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }
}