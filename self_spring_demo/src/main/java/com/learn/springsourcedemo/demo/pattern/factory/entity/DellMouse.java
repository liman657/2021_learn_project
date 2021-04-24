package com.learn.springsourcedemo.demo.pattern.factory.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:
 */
@Slf4j
public class DellMouse implements IMouse {
    @Override
    public void sayHi() {
        log.info("this is dell mouse");
    }
}
