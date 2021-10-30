package com.learn.concurrency.foundataion.jmm.singlepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021-10-28
 * comment:饿汉式单例设计模式（静态代码块）
 */
@Slf4j
public class HungarySingletonOther {

    private final static HungarySingletonOther INSTANCE ;

    static{
        INSTANCE = new HungarySingletonOther();
    }

    private HungarySingletonOther(){

    }

    public static HungarySingletonOther getInstance(){
        return INSTANCE;
    }

}
