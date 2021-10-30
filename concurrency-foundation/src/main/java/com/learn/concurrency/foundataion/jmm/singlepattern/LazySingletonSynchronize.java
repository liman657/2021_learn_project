package com.learn.concurrency.foundataion.jmm.singlepattern;

/**
 * autor:liman
 * createtime:2021-10-29
 * comment:懒汉式 线程不安全
 */
public class LazySingletonSynchronize {

    private static LazySingletonSynchronize instance;

    private LazySingletonSynchronize(){

    }

    public synchronized static LazySingletonSynchronize getInstance(){
        if(null == instance){
            instance =  new LazySingletonSynchronize();
        }
        return instance;
    }

}
