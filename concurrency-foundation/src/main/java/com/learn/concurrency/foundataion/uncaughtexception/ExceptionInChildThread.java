package com.learn.concurrency.foundataion.uncaughtexception;

/**
 * autor:liman
 * createtime:2021/9/20
 * comment:
 */
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new ExceptionInChildThread());
        thread.start();
        System.out.println("主线程运行");
        for(int i =0;i<500;i++){
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException("这个是子线程异常");
    }
}
