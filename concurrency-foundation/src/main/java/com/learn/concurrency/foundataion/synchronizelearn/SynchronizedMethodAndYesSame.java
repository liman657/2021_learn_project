package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:同时访问不同的同步方法
 */
public class SynchronizedMethodAndYesSame implements Runnable{

    private static SynchronizedMethodAndYesSame instance = new SynchronizedMethodAndYesSame();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if("Thread-0".equals(threadName)){
            syncMethod();
        }else{
            otherSyncMethod();
        }

    }

    public synchronized void syncMethod(){
        System.out.println("这个是同步加锁的方法，当前线程为:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void otherSyncMethod(){
        System.out.println("这个是【另一个】同步加锁的方法，当前线程为:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }


    public static void main(String[] args) {
        Thread threadOne = new Thread(instance);
        Thread threadTwo = new Thread(instance);
        threadOne.start();
        threadTwo.start();

        while(threadOne.isAlive() || threadTwo.isAlive()){

        }
        System.out.println("all thread finished");
    }
}
