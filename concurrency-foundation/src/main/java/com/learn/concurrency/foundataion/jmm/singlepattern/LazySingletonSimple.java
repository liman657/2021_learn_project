package com.learn.concurrency.foundataion.jmm.singlepattern;

/**
 * autor:liman
 * createtime:2021-10-29
 * comment:懒汉式 线程不安全
 */
public class LazySingletonSimple {

    private static LazySingletonSimple instance;

    private LazySingletonSimple(){

    }

    public static LazySingletonSimple getInstance(){
        if(null == instance){
            instance =  new LazySingletonSimple();
        }
        return instance;
    }

}
