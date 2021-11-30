package com.learn.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * autor:liman
 * createtime:2021/11/30
 * comment:AQS的简单实例
 * 自己用AQS实现一个简单的协作器
 */
@Slf4j
public class SelfCountDownLatchDemo {

    private final Sync sync = new Sync();

    public void await() {
        sync.acquireShared(0);
    }

    public void signal() {
        sync.releaseShared(0);
    }

    /**
     * 1、继承AQS实现获取和释放的方法
     */
    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;
//            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
//            return super.tryReleaseShared(arg);
            setState(1);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SelfCountDownLatchDemo selfCountDownLatchDemo = new SelfCountDownLatchDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"尝试获取自定义latch，获取失败就等待");
                selfCountDownLatchDemo.await();
                System.out.println(Thread.currentThread().getName()+"继续运行");
            }).start();
        }
        Thread.sleep(5000);
        selfCountDownLatchDemo.signal();//唤醒所有线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"尝试获取自定义latch，获取失败就等待");
            selfCountDownLatchDemo.await();
            System.out.println(Thread.currentThread().getName()+"继续运行");
        }).start();
    }
}