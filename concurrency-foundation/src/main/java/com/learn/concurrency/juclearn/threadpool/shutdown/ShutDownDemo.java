package com.learn.concurrency.juclearn.threadpool.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021-11-02
 * comment:
 */
public class ShutDownDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(new ShutDownTask());
        }
        Thread.sleep(1500);
        fixedThreadPool.shutdown();
    }

}

class ShutDownTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
