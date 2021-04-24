package com.learn.springsourcedemo.demo.pattern.factory.method;

import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment: 工厂方法模式实例
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        MouseFactory hpMouseFactory = new HpMouseFactory();
        IMouse hpMouse = hpMouseFactory.createMouse();
        hpMouse.sayHi();

        MouseFactory dellMouseFactory = new DellMouseFactory();
        IMouse dellMouse = dellMouseFactory.createMouse();
        dellMouse.sayHi();

        MouseFactory lenovoMouseFactory = new LenovoMouseFactory();
        IMouse lenoveMouse = lenovoMouseFactory.createMouse();
        lenoveMouse.sayHi();

    }

}
