package com.learn.concurrency.juclearn.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021-11-01
 * comment: 关闭线程池实例
 */
public class ShutDownThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            fixedThreadPool.execute(new ShutDownTask());
        }
        Thread.sleep(1500);
        //System.out.println(fixedThreadPool.isShutdown());
        //fixedThreadPool.shutdown();
        //System.out.println(fixedThreadPool.isShutdown());
        //Thread.sleep(1000);
        //System.out.println("isTerminate："+fixedThreadPool.isTerminated());
        //boolean shutdownResult = fixedThreadPool.awaitTermination(3l, TimeUnit.MINUTES);
        //System.out.println(shutdownResult);
        List<Runnable> runnables = fixedThreadPool.shutdownNow();
        System.out.println("还未运行的任务:"+runnables);

    }
}

class ShutDownTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"线程中断");
            e.printStackTrace();
        }
    }
}