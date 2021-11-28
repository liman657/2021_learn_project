package com.learn.concurrency.flowcontrol.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:模拟工厂质检
 * 一个产品的发布，需要5个人完成质检
 */
@Slf4j
public class CountDownLatchDemo01 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);//需要5个人完成质检
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int number = i+1;
            Runnable runnable=new Runnable(){
                @Override
                public void run() {
                    try {
                        //模拟质检的时间
                        long checkTime = (long) (Math.random() * 10000);
                        Thread.sleep(checkTime);
                        System.out.println("No."+number+"完成了质检，耗时："+checkTime+"ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //一个线程完成质检，就调用countDown方法，直到CountDownLatch的数值为0，则主线程就可以执行
                        countDownLatch.countDown();
                    }
                }
            };
            executorService.submit(runnable);
        }
        System.out.println("等待5个质检员检查完毕");
        //主线程等待5个子线程完成质检，调用CountDownLatch的await方法
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都完成了工作，产品可以对外发布");
        //停止线程池
        //判断线程池是否停止
        executorService.shutdown();
        while(!executorService.isTerminated()){
            //线程池没有执行完成任务，主线程就空转，直到线程池运行结束
        }
    }
}
