package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:对象锁示例2 方法锁
 */
public class ObjectLockMethod implements Runnable {

    private static ObjectLockMethod instance = new ObjectLockMethod();

    Object lock = new Object();


    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("对象锁的方法修饰，当前线程为:" + Thread.currentThread().getName());
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
