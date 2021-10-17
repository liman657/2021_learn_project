package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:对象锁-同步代码块
 */
public class ObjectLockBlock implements Runnable {

    private static ObjectLockBlock instance = new ObjectLockBlock();

    Object lock = new Object();


    public static void main(String[] args) {
        Thread threadOne = new Thread(instance);
        Thread threadTwo = new Thread(instance);
        threadOne.start();
        threadTwo.start();

        while(threadOne.isAlive() || threadTwo.isAlive()){

        }

        System.out.println("all thread finished");
    }

    @Override
    public void run() {
        //synchronize代码块，默认对象锁就是当前这个对象，也可以指定任意对象
        synchronized (this) {
            System.out.println("对象锁的代码块，当前线程为:" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}
