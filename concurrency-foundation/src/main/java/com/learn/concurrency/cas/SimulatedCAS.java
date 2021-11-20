package com.learn.concurrency.cas;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:模拟CAS的操作
 */
@Slf4j
public class SimulatedCAS implements Runnable{

    public volatile int value;

    public synchronized int compareAndSwap(int exceptedValue,int newValue){
        int oldValue = value;
        String currentThreadName = Thread.currentThread().getName();
        if(oldValue == exceptedValue){
            log.info("值被当前线程:{}修改",currentThreadName);
            value = newValue;
        }
        return oldValue;
    }

    @Override
    public void run() {
        compareAndSwap(0,1);
    }

    public static void main(String[] args) throws InterruptedException {
        SimulatedCAS runnable = new SimulatedCAS();
        runnable.value = 0;
        Thread threadOne = new Thread(runnable,"ThreadOne");
        Thread threadTwo = new Thread(runnable,"ThreadTwo");
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println(runnable.value);
    }
}
