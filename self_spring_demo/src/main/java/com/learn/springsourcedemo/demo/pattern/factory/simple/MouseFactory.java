package com.learn.springsourcedemo.demo.pattern.factory.simple;

import com.learn.springsourcedemo.demo.pattern.factory.entity.DellMouse;
import com.learn.springsourcedemo.demo.pattern.factory.entity.HpMouse;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:简单工厂设计模式实例
 */
public class MouseFactory {

    public static IMouse createMouse(int type) {
        switch (type) {
            case 0:
                return new DellMouse();
            case 1:
                return new HpMouse();
            default:
                return new DellMouse();
        }
    }

    public static void main(String[] args) {
        IMouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
        IMouse hpMouse = MouseFactory.createMouse(0);
        hpMouse.sayHi();
    }

}
