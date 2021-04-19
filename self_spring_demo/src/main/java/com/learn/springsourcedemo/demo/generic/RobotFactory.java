package com.learn.springsourcedemo.demo.generic;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * autor:liman
 * createtime:2021/4/19
 * comment:
 */
@Slf4j
public class RobotFactory implements GenericIFactory<String,Integer> {

    private String[] stringRobot = new String[]{"hello","hi"};
    private Integer[] integerRobot = new Integer[]{100,102};

    @Override
    public String nextObject() {
        Random random = new Random();
        return stringRobot[random.nextInt(2)];//[0,2)
    }

    @Override
    public Integer nextNumber() {
        Random random = new Random();
        return integerRobot[random.nextInt(2)];//[0,2)
    }

    public static void main(String[] args) {
        GenericIFactory<String,Integer> factory = new RobotFactory();
        log.info("{},{}",factory.nextObject(),factory.nextNumber());
    }
}

