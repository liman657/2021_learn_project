package com.learn.concurrency.foundataion.threadsecurity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * autor:liman
 * createtime:2021/9/22
 * comment: 运行结果出错的a++
 */
public class MultiThreadsErrorSimple implements Runnable {

    static MultiThreadsErrorSimple instance = new MultiThreadsErrorSimple();

    int index = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(instance);
        Thread threadTwo = new Thread(instance);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println(instance.index);
    }
}
