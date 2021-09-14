package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment:展示wait和notify的基本用法
 * 1、研究代码的执行顺序
 * 2、证明wait是释放锁的
 */
public class WaitNotifyDemo {

    public static Object object = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"线程1开始执行了");
                try {
                    object.wait();//wait会释放锁
                } catch (InterruptedException e) {//线程在wait的时候，可以响应中断
                    e.printStackTrace();
                }
                //线程从wait获得锁之后，继续从wait之后开始执行，而不是从开头开始执行
                System.out.println(Thread.currentThread().getName()+"线程1继续开始执行");
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                synchronized (object){
                    object.notify();
                    //线程2虽然执行了notify，但是并不会立刻释放这把锁，而是执行完synchronize代码块之后，才释放这把锁
                    System.out.println("线程"+Thread.currentThread().getName()+"调用了notify");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);//保证wait在notify之前执行
        thread2.start();
    }


}
