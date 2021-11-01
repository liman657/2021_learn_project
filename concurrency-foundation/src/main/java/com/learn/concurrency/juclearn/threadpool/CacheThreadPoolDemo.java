package com.learn.concurrency.juclearn.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021-11-01
 * comment:
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<1000;i++){
            executorService.execute(new CacheThreadTask());
        }
    }
}

class CacheThreadTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
