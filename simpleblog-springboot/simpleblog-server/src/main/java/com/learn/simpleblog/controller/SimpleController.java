package com.learn.simpleblog.controller;

import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * autor:liman
 * createtime:2021-12-27
 * comment:简单测试的controller
 */
@RestController
@Slf4j
@RequestMapping("simple")
public class SimpleController {

    @GetMapping("test")
    public BaseResponse simpleTest(){
        log.info("开始测试controller请求");
        BaseResponse result = new BaseResponse(StatusCode.Success);
        return result;
    }
}
