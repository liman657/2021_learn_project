package com.learn.springsourcedemo.demo.pattern.factory.method;

import com.learn.springsourcedemo.demo.pattern.factory.entity.HpMouse;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:
 */
public class HpMouseFactory implements MouseFactory {
    @Override
    public IMouse createMouse() {
        return new HpMouse();
    }
}
