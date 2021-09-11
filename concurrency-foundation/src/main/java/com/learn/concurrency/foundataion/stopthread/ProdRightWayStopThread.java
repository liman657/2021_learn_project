package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:生产中正确的停止线程的方式之一 强制要求子方法抛出InterruptedException的异常
 */
public class ProdRightWayStopThread implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println("running");
            try {
                catchInterruptInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

        }
    }

    private void catchInterruptInMethod() throws InterruptedException {
        //线程的调用方法中，sleep的时候针对中断异常的处理并没有抛出
            //sleep模拟子线程在运行
            Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ProdRightWayStopThread());
        thread.start();
        Thread.sleep(900);
        thread.interrupt();
    }
}
