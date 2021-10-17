package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:同时访问同步方法和非同步方法
 */
public class StaticSynchronizedMethodAndNormalSame implements Runnable{

    private static StaticSynchronizedMethodAndNormalSame instance = new StaticSynchronizedMethodAndNormalSame();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if("Thread-0".equals(threadName)){
            syncMethod();
        }else{
            noSyncMethod();
        }

    }

    public static synchronized void syncMethod(){
        System.out.println("这个是同步加锁的方法【静态】，当前线程为:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void noSyncMethod(){
        System.out.println("这个是同步加锁的方法【非静态】，当前线程为:" + Thread.currentThread().getName());
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
