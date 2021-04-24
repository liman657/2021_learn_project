package com.learn.springsourcedemo.demo.pattern.factory.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:
 */
@Slf4j
public class LenovoMouse implements IMouse {
    @Override
    public void sayHi() {
      log.info("这是联想的鼠标");
    }
}
