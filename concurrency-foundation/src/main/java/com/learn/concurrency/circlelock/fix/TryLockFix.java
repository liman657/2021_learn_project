package com.learn.concurrency.circlelock.fix;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment: 多用tryLock，设置超时时间，可以避免死锁
 */
public class TryLockFix implements Runnable {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    int flag = 1;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(flag == 1){
                try {
                    if(lock1.tryLock(800,TimeUnit.MILLISECONDS)){
                        System.out.println("线程"+Thread.currentThread().getName()+"已获取lock1锁");
                        if(lock2.tryLock(800,TimeUnit.MILLISECONDS)){
                            System.out.println("线程"+Thread.currentThread().getName()+"已获取lock2锁，可以开始正常处理业务");
                            Thread.sleep(new Random().nextInt(1000));
                            //处理完业务之后，释放两把锁
                            lock2.unlock();
                            lock1.unlock();
                        }else{
                            System.out.println("线程"+Thread.currentThread().getName()+"已获取lock1锁,但未获取lock2锁，为了避免死锁，现在释放已获取的lock1锁");
                            lock1.unlock();//为了避免死锁，释放已经获取的锁
                            Thread.sleep(new Random().nextInt(1000));


                        }
                    }else{
                        System.out.println("线程"+Thread.currentThread().getName()+"未获取lock1锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(flag == 0){
                try {
                    if(lock2.tryLock(800,TimeUnit.MILLISECONDS)){
                        System.out.println("线程"+Thread.currentThread().getName()+"已获取lock2锁");
                        if(lock1.tryLock(800,TimeUnit.MILLISECONDS)){
                            System.out.println("线程"+Thread.currentThread().getName()+"已获取lock1锁，可以开始正常处理业务");
                            Thread.sleep(new Random().nextInt(1000));
                            //处理完业务之后，释放两把锁
                            lock1.unlock();
                            lock2.unlock();
                        }else{
                            System.out.println("线程"+Thread.currentThread().getName()+"已获取lock2锁,但未获取lock1锁，为了避免死锁，现在释放已获取的lock1锁");
                            lock2.unlock();//为了避免死锁，释放已经获取的锁
                            Thread.sleep(new Random().nextInt(1000));


                        }
                    }else{
                        System.out.println("线程"+Thread.currentThread().getName()+"未获取lock1锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLockFix threadOne = new TryLockFix();
        TryLockFix threadTwo = new TryLockFix();
        threadOne.flag = 1;
        threadTwo.flag = 0;
        new Thread(threadOne).start();
        new Thread(threadTwo).start();
    }
}
