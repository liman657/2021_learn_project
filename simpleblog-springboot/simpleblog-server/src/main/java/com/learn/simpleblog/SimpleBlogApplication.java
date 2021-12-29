package com.learn.simpleblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * autor:liman
 * createtime:2021-12-27
 * comment:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.learn.simpleblog.module.mapper")
public class SimpleBlogApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SimpleBlogApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleBlogApplication.class,args);
    }
}
