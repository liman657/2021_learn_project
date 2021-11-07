package com.learn.concurrency.juclearn.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021-11-01
 * comment:scheduledThreadPool的实例
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService
                = Executors.newScheduledThreadPool(10);
        //延迟五秒执行指定的任务
        //executorService.schedule(new ScheduledTask(),5, TimeUnit.SECONDS);
        //刚开始第一次，1秒后执行任务，之后每隔3秒钟再执行一次
        executorService.scheduleAtFixedRate(new ScheduledTask(),1,3,TimeUnit.SECONDS);
    }
}
class ScheduledTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}