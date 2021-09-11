package com.learn.concurrency.foundataion.startthread;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/8
 * comment:对比start和run两种启动线程的方式
 */
@Slf4j
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName());
        };
        //当成普通的类方法执行
        runnable.run();

        new Thread(runnable).start();
    }

}
