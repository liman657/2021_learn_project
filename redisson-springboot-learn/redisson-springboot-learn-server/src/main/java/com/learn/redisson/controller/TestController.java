package com.learn.redisson.controller;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import jdk.net.SocketFlow;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: 测试 Controller
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    //redisson提供的redissonClient是线程安全的
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value="test",method = RequestMethod.GET)
    public BaseResponse testController(){
        log.info("进入测试请求");
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            RKeys rKeys = redissonClient.getKeys();
            Iterable<String> keys = rKeys.getKeys();
            Set<String> resultKeys = new HashSet<>();
            keys.forEach(s->resultKeys.add(s));
            response.setData(keys);
            log.info("获取到的key集合为:{}",keys.toString());
        }catch (Exception e){
            log.error("测试请求出现异常，异常信息为:{}",e);
        }
        return response;
    }



}
