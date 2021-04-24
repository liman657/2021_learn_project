package com.learn.springsourcedemo.demo.pattern.factory.abstactf;

import com.learn.springsourcedemo.demo.pattern.factory.entity.IKeyBoard;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;
import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:
 */
@Slf4j
public class PcFactoryDemo {

    public static void main(String[] args) {
        PcFactory pcFactory = new DellPcFactory();
        IKeyBoard keyBoard = pcFactory.createKeyBoard();
        keyBoard.sayHello();
        IMouse mouse = pcFactory.createMouse();
        mouse.sayHi();
    }

}
