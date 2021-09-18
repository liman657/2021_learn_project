package com.learn.concurrency.foundataion.threadobjectcommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/9/17
 * comment:
 */
public class SleepInterrupted implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+":被中断了");
                e.printStackTrace();
            }
        }
    }
}
