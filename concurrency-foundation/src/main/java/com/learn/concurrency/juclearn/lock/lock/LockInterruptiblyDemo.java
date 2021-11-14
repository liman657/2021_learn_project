package com.learn.concurrency.juclearn.lock.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:获取锁的过程中，响应中断
 */
@Slf4j
public class LockInterruptiblyDemo implements Runnable{

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyDemo lockInterruptiblyDemo = new LockInterruptiblyDemo();
        Thread threadOne = new Thread(lockInterruptiblyDemo,"线程1");
        Thread threadTwo = new Thread(lockInterruptiblyDemo,"线程2");
        threadOne.start();
        threadTwo.start();
        //main线程休眠2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //刚启动的线程1会进入休眠，会在sleep的时候被中断
        threadOne.interrupt();//打断线程1和打断线程2会有不同的结果，因为其中有一个是sleep，有一个是尝试获取锁
        //后启动的线程2会在尝试获取锁的时候被中断
        threadTwo.interrupt();
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName+"尝试获取锁");
        try {
            lock.lockInterruptibly();
            try{
                System.out.println(currentThreadName+"获取到了锁");
                Thread.sleep(5000);
            }catch (InterruptedException e){//这里还是相应并处理Thread.sleep(5000);期间的中断异常
                System.out.println(currentThreadName+"休眠期间被中断");
            }finally {
                lock.unlock();
                System.out.println(currentThreadName+"释放锁成功");
            }
        } catch (InterruptedException e) {//这里是针对lock.lockInterruptibly();被中断的异常处理
            e.printStackTrace();
            System.out.println(currentThreadName+"尝试获取锁的时候被中断，这里是中断抛出的异常");
        }
    }
}
