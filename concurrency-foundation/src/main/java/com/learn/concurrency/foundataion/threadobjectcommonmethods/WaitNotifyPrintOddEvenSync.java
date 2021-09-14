package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment:两个线程交替打印0~100的奇偶数
 * 用synchronized关键字实现
 */
public class WaitNotifyPrintOddEvenSync {

    private static int count;

    private static final Object lock = new Object();

    //建立两个线程，一个只处理偶数，一个只处理奇数（用位运算处理）
    //线程完成自己工作的同时，还需要考虑其他线程的输出，这里用synchronize来通信

    public static void main(String[] args) {
        Thread thread01 = new Thread(() -> {
            while(count<100){
                synchronized (lock){
                    if((count&1) == 0){
                        System.out.println(Thread.currentThread().getName()+": 输出偶数"+(count++));
                    }
                }
            }
        },"偶数");

        Thread thread02 = new Thread(() -> {
            while(count<100){
                synchronized (lock){
                    if((count&1) != 0){
                        System.out.println(Thread.currentThread().getName()+": 输出奇数"+(count++));
                    }
                }
            }
        },"奇数");

        thread01.start();
        thread02.start();
    }
}