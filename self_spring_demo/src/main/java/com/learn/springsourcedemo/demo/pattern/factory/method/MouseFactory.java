package com.learn.springsourcedemo.demo.pattern.factory.method;

import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:工厂方法模式
 */
public interface MouseFactory {

    IMouse createMouse();

}
