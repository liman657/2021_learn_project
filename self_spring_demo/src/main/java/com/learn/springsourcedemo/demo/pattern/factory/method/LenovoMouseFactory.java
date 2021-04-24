package com.learn.springsourcedemo.demo.pattern.factory.method;

import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;
import com.learn.springsourcedemo.demo.pattern.factory.entity.LenovoMouse;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:
 */
public class LenovoMouseFactory implements MouseFactory {
    @Override
    public IMouse createMouse() {
        return new LenovoMouse();
    }
}
