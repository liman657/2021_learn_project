package com.learn.concurrency.foundataion.jmm.singlepattern;

/**
 * autor:liman
 * createtime:2021-10-29
 * comment: 单例模式，双重检测
 */
public class SingletonDoubleCheck {

    //由于新建对象的操作并不是原子的，而是有三步，而这三步指令，可能被CPU重排序
    //这三步重排序可能发生NPE问题
    //因此要用volatile修饰，一个是保证可见性，同时防止指令重排序
    private static volatile SingletonDoubleCheck instance;

    private SingletonDoubleCheck(){

    }

    public static SingletonDoubleCheck getInstance(){
        if(null == instance){
            synchronized (SingletonDoubleCheck.class){
                if(null == instance){
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

}
