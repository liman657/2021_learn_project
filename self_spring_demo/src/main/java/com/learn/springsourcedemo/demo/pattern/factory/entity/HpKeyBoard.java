package com.learn.springsourcedemo.demo.pattern.factory.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:
 */
@Slf4j
public class HpKeyBoard implements IKeyBoard {
    @Override
    public void sayHello() {
      log.info("这是惠普的键盘");
    }
}
