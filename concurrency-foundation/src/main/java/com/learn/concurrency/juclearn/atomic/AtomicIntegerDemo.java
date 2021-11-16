package com.learn.concurrency.juclearn.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * autor:liman
 * createtime:2021/11/15
 * comment:AtomicInteger的简单实例
 * AtomicInteger
 * AtomicLong
 * AtomicBoolean
 * 以AtomicInteger为例
 */
@Slf4j
public class AtomicIntegerDemo implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static volatile int basicCount = 0;

    public void incrementAtomicValue() {
        atomicInteger.getAndIncrement();
    }

    public void incrementBasicValue() {
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementAtomicValue();
            incrementBasicValue();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread threaOne = new Thread(atomicIntegerDemo);
        Thread threadTwo = new Thread(atomicIntegerDemo);
        threaOne.start();
        threadTwo.start();
        threaOne.join();
        threadTwo.join();
        System.out.println("原子类的结果:"+atomicInteger.get());
        System.out.println("普通类的结果:"+basicCount);
    }
}
