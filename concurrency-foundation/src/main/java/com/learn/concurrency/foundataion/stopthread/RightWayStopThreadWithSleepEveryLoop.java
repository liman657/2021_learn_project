package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/9
 * comment: 如果在执行过程中，每次执行都会sleep或者wait等待，则不需要每次迭代中都判断中断标记
 */
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while (num <= 10000 ) {
                    if (num % 100 == 0) {
                        System.out.println(num + " is 100的倍数");
                    }
                    num++;
                    Thread.sleep(10);//执行完运算之后，等待1秒
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
