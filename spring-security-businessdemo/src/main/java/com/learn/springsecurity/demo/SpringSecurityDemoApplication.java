package com.learn.springsecurity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * autor:liman
 * createtime:2021/6/28
 * comment:
 */
@SpringBootApplication
@RestController
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }

}
