package com.learn.concurrency.foundataion.threadproperty;

/**
 * autor:liman
 * createtime:2021/9/19
 * comment:线程Id演示,id变量从0开始，但是是++threadId的形式返回，所以初创线程的主线程id为1
 */
public class ThreadIdProperty {

    public static void main(String[] args) {
        System.out.println("主线程的id:"+Thread.currentThread().getId());
        new Thread(()->{
            System.out.println("子线程的id:"+Thread.currentThread().getId());
        }).start();
    }

}
