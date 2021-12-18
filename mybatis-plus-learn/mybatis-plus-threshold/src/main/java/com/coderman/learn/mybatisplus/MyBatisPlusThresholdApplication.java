package com.coderman.learn.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * autor:liman
 * createtime:2021/12/18
 * comment:
 */
@SpringBootApplication
@MapperScan("com.coderman.learn.mybatisplus.mapper")
public class MyBatisPlusThresholdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusThresholdApplication.class);
    }
}
