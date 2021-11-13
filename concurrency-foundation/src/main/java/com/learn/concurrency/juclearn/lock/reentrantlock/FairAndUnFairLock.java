package com.learn.concurrency.juclearn.lock.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:公平锁和非公平锁的简单实例
 */
@Slf4j
public class FairAndUnFairLock {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0;i<10;i++){
            thread[i] = new Thread(new Job(printQueue));
        }

        for(int i=0;i<10;i++){
            thread[i].start();
            //为了保证顺序启动，这里休眠一下
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Job implements Runnable{

    PrintQueue printQueue;

    public Job(PrintQueue printQueue){
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始打印");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName()+"打印完毕");

    }
}
class PrintQueue {
    private Lock queueLock = new ReentrantLock(true);//传入true ,定义为公平锁

    public void printJob(Object document) {
        //第一次打印
        queueLock.lock();
        try {
            int duration = new Random().nextInt(10)+1;
            System.out.println(Thread.currentThread().getName() + "正在打印第一份文件，打印任务需要花费:" + duration  + "秒");
            Thread.sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        //第二次打印
        queueLock.lock();
        try {
            int duration = new Random().nextInt(10)+1;
            System.out.println(Thread.currentThread().getName() + "正在打印第二份文件，打印任务需要花费:" + duration + "秒");
            Thread.sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
