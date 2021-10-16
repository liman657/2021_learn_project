package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/17
 * comment:join的演示
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        });
        thread1.start();
        thread2.start();
        System.out.println("主线程开始等待子线程运行完毕");
        //这里的join由子线程的对象进行调用，但含义实质是将子线程加入到主线程中
        thread1.join();//含义：子线程加入到主线程中，主线程需要等待子线程执行完毕之后再运行
        thread2.join();
        System.out.println("所有子线程执行完毕，下面主线程可以运行了");
        Thread.sleep(500);
        System.out.println("主线程执行完毕");
    }

}
