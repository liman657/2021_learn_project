package com.learn.concurrency.foundataion.jmm.volatilelearn;

/**
 * autor:liman
 * createtime:2021-10-25
 * comment:volatile关键字无法适用的场景
 */
public class VolatileNoWork implements Runnable {

    volatile int a;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new VolatileNoWork();
        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        //这里输出的并不是200000
        System.out.println(((VolatileNoWork)runnable).a);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            a++;
        }
    }
}
