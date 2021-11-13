package com.learn.concurrency.juclearn.lock.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment: Lock的基本使用
 */
@Slf4j
public class LockMustUnLockDemo {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
