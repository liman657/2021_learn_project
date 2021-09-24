package com.learn.concurrency.foundataion.threadsecurity;

/**
 * autor:liman
 * createtime:2021/9/23
 * comment:死锁示例
 */
public class DeadLockDemo implements Runnable{

    int flag = 1;
    static Object object01 = new Object();
    static Object object02 = new Object();

    @Override
    public void run() {

    }
}
