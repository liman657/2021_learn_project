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
        //初始化一个Runnable
        Runnable runnable = ()->{
            log.info("当前线程的线程名为:{}",Thread.currentThread().getName());
        };
        //直接调用run方法，会当成一个普通方式执行
        runnable.run();

        //单独启动一个线程
        new Thread(runnable).start();
    }
}