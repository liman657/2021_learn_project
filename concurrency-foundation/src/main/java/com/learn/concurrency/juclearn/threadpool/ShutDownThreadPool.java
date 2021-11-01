package com.learn.concurrency.juclearn.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021-11-01
 * comment: 关闭线程池实例
 */
public class ShutDownThreadPool {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
    }

}

class ShutDownTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}