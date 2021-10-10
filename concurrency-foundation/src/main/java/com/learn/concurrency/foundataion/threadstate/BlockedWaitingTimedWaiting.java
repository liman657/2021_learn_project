package com.learn.concurrency.foundataion.threadstate;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:演示线程 blocked waiting TimeWaiting的三种状态
 */
@Slf4j
public class BlockedWaitingTimedWaiting implements Runnable{
    @Override
    public void run() {
        sync();
    }

    private synchronized void sync(){
        try {
            Thread.sleep(1000);//sleep的状态是一种TIMED_WAITING的状态
            wait();//线程执行完sleep，就会进入到wait状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            //主线程暂停一下，以便拿到线程最新的状态
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TIME_WAITING，因为线程1正在sleep
        log.info("线程1当前的状态为：{}",thread1.getState());
        //线程2想拿到sync的锁，但是拿不到，这里线程2就是BLOCKED状态
        log.info("线程2当前的状态为：{}",thread2.getState());
        try {
            //主线程暂停一下，以便线程1进入到wait状态线程最新的状态
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //由于调用了wait方法，这里线程1就是wait状态
        log.info("线程1当前的状态为：{}",thread1.getState());
    }
}
