package com.learn.concurrency.foundataion.jmm.singlepattern;

/**
 * autor:liman
 * createtime:2021-10-29
 * comment:单例模式 静态内部类
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){

    }

    private static class SingleInnerInstance{
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return SingleInnerInstance.instance;
    }

}
