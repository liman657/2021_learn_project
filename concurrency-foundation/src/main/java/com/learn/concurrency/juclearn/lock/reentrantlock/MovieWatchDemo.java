package com.learn.concurrency.juclearn.lock.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/14
 * comment:ReentrantLock的简单用法，模拟四个线程订票
 */
@Slf4j
public class MovieWatchDemo {

    private static ReentrantLock lock = new ReentrantLock();

    private static void bookSeat(){
        lock.lock();
        try{
            String currentThreadName = Thread.currentThread().getName();
            System.out.println(currentThreadName+"开始预定座位");
            Thread.sleep(1000);
            System.out.println(currentThreadName+"完成座位预定");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(()->{bookSeat();}).start();
        new Thread(()->{bookSeat();}).start();
        new Thread(()->{bookSeat();}).start();
        new Thread(()->{bookSeat();}).start();
    }
}
