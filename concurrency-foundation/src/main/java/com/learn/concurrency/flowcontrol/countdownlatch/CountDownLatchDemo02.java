package com.learn.concurrency.flowcontrol.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:模拟运动会的运动员跑步
 * 多个运动员等待统一指令起跑
 * 同时所有运动员都到终点的时候才能结束比赛
 */
@Slf4j
public class CountDownLatchDemo02 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch beginCountDownLatch = new CountDownLatch(1);
        CountDownLatch endCountDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i+1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No."+no+"准备完毕，等待发令枪发令");
                    try {
                        beginCountDownLatch.await();//子线程会在这里阻塞，等待主线程发出指令
                        System.out.println("No."+no+"开始跑步");
                        long runTime = (long) (Math.random() * 10000);
                        Thread.sleep(runTime);//模拟随机的跑步时长，执行完毕之后，表示跑到终点
                        System.out.println("No."+no+"到达终点，耗时："+runTime+"ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //到达终点，发出信号
                        endCountDownLatch.countDown();
                    }
                }
            };
            executorService.submit(runnable);
        }
        //主线程其实就是裁判，模拟裁判准备工作
        Thread.sleep(5000);
        System.out.println("发令枪响，开始跑步");
        beginCountDownLatch.countDown();
        endCountDownLatch.await();//主线程阻塞，裁判员继续等待所有运动员到达终点。
        System.out.println("所有人都到终点，比赛结束");
        //判断线程池是否停止
        executorService.shutdown();
        while(!executorService.isTerminated()){
            //线程池没有执行完成任务，主线程就空转，直到线程池运行结束
        }
    }
}
