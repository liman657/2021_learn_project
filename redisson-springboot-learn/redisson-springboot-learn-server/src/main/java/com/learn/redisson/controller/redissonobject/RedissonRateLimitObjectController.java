package com.learn.redisson.controller.redissonobject;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.server.IRateLimiterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment:RateLimit限流器的对象实例controller
 */
@Slf4j
@RequestMapping("/distobj")
@RestController
public class RedissonRateLimitObjectController {

    @Autowired
    private IRateLimiterService rateLimiterService;

    //发送短信的接口
    @GetMapping("ratelimit/sendmsg")
    public BaseResponse sendMsg(@RequestParam String phone){
        log.info("rate limit 发送短信");
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            rateLimiterService.sendMsg(phone);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

}
