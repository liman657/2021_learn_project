package com.learn.concurrency.foundataion.threadsecurity;

/**
 * autor:liman
 * createtime:2021/9/23
 * comment:死锁示例（第二种线程安全问题）
 */
public class DeadLockDemo implements Runnable{

    int flag = 1;
    static Object object01 = new Object();
    static Object object02 = new Object();

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo01 = new DeadLockDemo();
        DeadLockDemo deadLockDemo02 = new DeadLockDemo();
        deadLockDemo01.flag=1;
        deadLockDemo02.flag=0;
        Thread thread01 = new Thread(deadLockDemo01);
        Thread thread02 = new Thread(deadLockDemo02);
        thread01.start();
        thread02.start();

    }

    @Override
    public void run() {
        System.out.println("当前的flag="+flag);
        if(1==flag){
            synchronized (object01){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object02){
                    System.out.println("escape dead lock,flag:1");
                }
            }
        }else{
            synchronized (object02){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object01){
                    System.out.println("escape dead lock,flag:1");
                }
            }
        }
    }
}
