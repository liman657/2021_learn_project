package com.learn.concurrency.foundataion.synchronizelearn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:
 */
public class RenentrantLockDemo {

    Lock lock = new ReentrantLock();

    public synchronized void method01() {
        System.out.println("synchronized的同步方式");
    }

    /**
     * 有了synchronized，就不用考虑这么多
     */
    public void lockSync() {
        lock.lock();
        try {
            System.out.println("lock的同步方式");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {


    }

}
