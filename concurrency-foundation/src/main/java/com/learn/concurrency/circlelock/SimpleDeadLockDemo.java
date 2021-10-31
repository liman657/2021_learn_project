package com.learn.concurrency.circlelock;

/**
 * autor:liman
 * createtime:2021/9/23
 * comment:死锁示例（第二种线程安全问题）
 */
public class SimpleDeadLockDemo implements Runnable{

    int flag = 1;
    static Object object01 = new Object();
    static Object object02 = new Object();

    public static void main(String[] args) {
        SimpleDeadLockDemo deadLockDemo01 = new SimpleDeadLockDemo();
        SimpleDeadLockDemo deadLockDemo02 = new SimpleDeadLockDemo();
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
