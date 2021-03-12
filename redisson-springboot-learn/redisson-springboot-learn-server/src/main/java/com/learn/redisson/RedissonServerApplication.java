package com.learn.redisson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * autor:liman
 * createtime:2021/2/19
 * comment:
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml"})
@MapperScan(basePackages = "com.learn.redisson.module.mapper")
@EnableScheduling
@EnableAsync
public class RedissonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonServerApplication.class);
    }

}
