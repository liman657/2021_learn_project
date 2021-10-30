package com.learn.concurrency.foundataion.jmm.singlepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021-10-28
 * comment:饿汉式单例设计模式
 */
@Slf4j
public class HungarySingleton {

    private final static HungarySingleton INSTANCE = new HungarySingleton();

    private HungarySingleton(){

    }

    public static HungarySingleton getInstance(){
        return INSTANCE;
    }

}
