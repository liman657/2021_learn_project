package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/17
 * comment:join的演示
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            
        });

        Thread thread2 = new Thread(()->{

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
