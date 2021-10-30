package com.learn.concurrency.foundataion.jmm.singlepattern;

/**
 * autor:liman
 * createtime:2021-10-29
 * comment:懒汉式 线程不安全
 */
public class LazySingletonSynchronizeLettle {

    private static LazySingletonSynchronizeLettle instance;

    private LazySingletonSynchronizeLettle(){

    }

    public synchronized static LazySingletonSynchronizeLettle getInstance(){
        if(null == instance){
            synchronized (LazySingletonSynchronizeLettle.class) {
                instance = new LazySingletonSynchronizeLettle();
            }
        }
        return instance;
    }

}
