package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:各种interrupt关联方法的结果【
 */
public class RightWayInterruptMethod {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //输出当前线程的中断标志结果（当前线程是main，不管调用这个方法的对象是什么，因为这个方法是静态方法）
        System.out.println("isInterrupted: " + threadOne.interrupted());
        //输出当前线程的中断标志结果（当前线程是main）
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
