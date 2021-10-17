package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:类锁的第一种形式，static形式
 */
public class ClassLockStatic implements Runnable{

    private static ClassLockStatic instance1 = new ClassLockStatic();
    private static ClassLockStatic instance2 = new ClassLockStatic();
    @Override
    public void run() {
        method();
    }

    public synchronized static void method(){
        System.out.println("类锁的方法修饰，当前线程为:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(instance1);
        Thread threadTwo = new Thread(instance2);
        threadOne.start();
        threadTwo.start();

        while(threadOne.isAlive() || threadTwo.isAlive()){

        }

        System.out.println("all thread finished");
    }
}
