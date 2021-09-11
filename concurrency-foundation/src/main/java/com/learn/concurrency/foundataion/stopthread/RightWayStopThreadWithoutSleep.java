package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/9
 * comment: run方法内没有sleep或wait方法的时候停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        //boolean isInterrut = Thread.currentThread().isInterrupted();//还不能这样写，这样调用之后标记为会被清空
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + " is 10000 的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
