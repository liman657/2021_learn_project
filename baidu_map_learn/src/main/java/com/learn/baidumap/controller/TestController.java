package com.learn.baidumap.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * autor:liman
 * createtime:2021/8/16
 * comment:
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get")
    public String testMethod(){
        return "simpleTest";
    }

}
