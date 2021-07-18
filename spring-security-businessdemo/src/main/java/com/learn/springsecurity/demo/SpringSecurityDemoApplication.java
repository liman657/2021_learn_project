package com.learn.springsecurity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * autor:liman
 * createtime:2021/6/28
 * comment:
 */
@SpringBootApplication
@RestController
@EnableSwagger2
@ComponentScan(basePackages = {"com.learn.springsecurity.browser","com.learn.springsecurity.demo"
,"com.learn.springsecurity.core"})
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello spring springsecurity";
    }

}