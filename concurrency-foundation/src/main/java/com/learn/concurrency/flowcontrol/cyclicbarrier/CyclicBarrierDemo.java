package com.learn.concurrency.flowcontrol.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:循环栅栏的实例
 * 相比于CountDownLatch，CyclicBarrier是可重用的
 */
@Slf4j
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //实例化一个CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有人都到了，大家统一出发");
            }
        });

        for(int i=0;i<10;i++){
            new Thread(new Task(i,cyclicBarrier)).start();
        }
    }

    static class Task implements Runnable{

        private int id;
        private CyclicBarrier cyclicBarrier;

        public Task(int id,CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+id+"现在前往集合地点");
            try {
                Thread.sleep((long) (Math.random()*10000));
                System.out.println("线程"+id+"到了集合地点，开始等待其他线程到达");
                cyclicBarrier.await();//等待其他线程到达。
                System.out.println("线程"+id+"出发");//所有线程都就位了，就会一起执行这个代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}