package com.learn.concurrency.foundataion.uncaughtexception;

/**
 * autor:liman
 * createtime:2021/9/20
 * comment:想在主线程中捕获子线程的异常，想象很美好，其实主线程无法处理子线程抛出的异常
 */
public class CatchSubThreadExceptionInMainThread implements Runnable {

    public static void main(String[] args) {
        try {
            Thread thread01 = new Thread(new CatchSubThreadExceptionInMainThread());
            thread01.start();
            Thread thread02 = new Thread(new CatchSubThreadExceptionInMainThread());
            thread02.start();
            Thread thread03 = new Thread(new CatchSubThreadExceptionInMainThread());
            thread03.start();
            Thread thread04 = new Thread(new CatchSubThreadExceptionInMainThread());
            thread04.start();
        }catch (Exception e){
            System.out.println("主线程捕获到子线程的异常，并进行处理，异常信息为"+e);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException("这个是子线程异常");
    }
}
