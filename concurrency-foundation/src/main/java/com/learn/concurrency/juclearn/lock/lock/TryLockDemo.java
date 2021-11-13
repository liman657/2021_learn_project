package com.learn.concurrency.juclearn.lock.lock;

import lombok.extern.slf4j.Slf4j;

import javax.management.relation.RelationNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:TryLock避免deadLock
 */
@Slf4j
public class TryLockDemo implements Runnable{

    int flag = 1;
    static Lock lockOne = new ReentrantLock();
    static Lock lockTwo = new ReentrantLock();

    public static void main(String[] args) {
        TryLockDemo tryLockDemoOne = new TryLockDemo();
        TryLockDemo tryLockDemoTwo = new TryLockDemo();
        tryLockDemoOne.flag = 1;
        tryLockDemoTwo.flag = 2;
        new Thread(tryLockDemoOne).start();
        new Thread(tryLockDemoTwo).start();
    }

    @Override
    public void run() {
        while(true) {
            //如果flag=1，先获取锁1再获取锁2
            if (flag == 1) {
                try {
                    if (lockOne.tryLock(800, TimeUnit.MILLISECONDS)) {//试图获取锁，如果获取到了锁，则进入if
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到了锁1");
                            Thread.sleep(1000);
                            //尝试获取第二把锁
                            if (lockTwo.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + "获取锁2成功，目前持有两把锁");
                                    //模拟执行业务逻辑
                                    Thread.sleep(1000);
                                } finally {
                                    lockTwo.unlock();
                                    System.out.println(Thread.currentThread().getName() + "释放锁2");
                                }
                            } else {
                                System.out.println(Thread.currentThread().getName() + "获取锁2失败");
                            }
                        } finally {
                            lockOne.unlock();//解锁，释放锁1
                            System.out.println(Thread.currentThread().getName()+"释放锁1");
                            Thread.sleep(500);//给其他线程获取锁的时间
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "获取锁1失败");
                    }
                } catch (InterruptedException e) {//在tryLock的期间，可以响应中断
                    e.printStackTrace();
                }
            }

            //如果flag=2，先获取锁2再获取锁1
            if (flag == 2) {
                try {
                    if (lockTwo.tryLock(800, TimeUnit.MILLISECONDS)) {//试图获取锁，如果获取到了锁，则进入if
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到了锁2");
                            Thread.sleep(1000);
                            //尝试获取第二把锁
                            if (lockOne.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + "获取锁1成功，目前持有两把锁");
                                    //模拟执行业务逻辑
                                    Thread.sleep(1000);
                                } finally {
                                    lockOne.unlock();
                                    System.out.println(Thread.currentThread().getName() + "释放锁1");
                                }
                            } else {
                                System.out.println(Thread.currentThread().getName() + "获取锁1失败");
                            }
                        } finally {
                            lockTwo.unlock();//解锁，释放锁1
                            System.out.println(Thread.currentThread().getName()+"释放锁2");
                            Thread.sleep(500);//给其他线程获取锁的时间
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "获取锁2失败");
                    }
                } catch (InterruptedException e) {//在tryLock的期间，可以响应中断
                    e.printStackTrace();
                }
            }
        }
    }
}
