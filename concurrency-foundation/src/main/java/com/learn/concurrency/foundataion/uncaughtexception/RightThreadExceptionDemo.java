package com.learn.concurrency.foundataion.uncaughtexception;

/**
 * autor:liman
 * createtime:2021/9/20
 * comment:正常的线程异常处理实例
 */
public class RightThreadExceptionDemo implements Runnable{


    public static void main(String[] args) {

        //设置线程的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new SelfThreadExceptionHandler());

        Thread thread01 = new Thread(new RightThreadExceptionDemo());
        thread01.start();
        Thread thread02 = new Thread(new RightThreadExceptionDemo());
        thread02.start();
        Thread thread03 = new Thread(new RightThreadExceptionDemo());
        thread03.start();
        Thread thread04 = new Thread(new RightThreadExceptionDemo());
        thread04.start();
    }

    @Override
    public void run() {
        throw new RuntimeException("子线程运行出现异常");
    }
}
