package com.learn.concurrency.juclearn.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * autor:liman
 * createtime:2021/11/14
 * comment:自旋锁简单实例
 */
public class SpinLockDemo {

    private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        while(!sign.compareAndSet(null,currentThread)){
            System.out.println(currentThread.getName()+"获取锁失败，自旋中......");
        }
    }

    public void unlock(){
        Thread currentThread = Thread.currentThread();
        sign.compareAndSet(currentThread,null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String currentThreadName = Thread.currentThread().getName();
                System.out.println(currentThreadName + "开始尝试获取自旋锁");
                spinLock.lock();
                System.out.println(currentThreadName + "获取自旋锁成功");
                try {
                    //模拟业务处理
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    spinLock.unlock();
                    System.out.println(currentThreadName + "释放自旋锁成功");
                }
            }
        };
        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        threadOne.start();
        threadTwo.start();
    }
}