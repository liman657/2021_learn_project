package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/9
 * comment: run方法内有sleep或wait方法的时候停止线程
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            while(num<=300 && !Thread.currentThread().isInterrupted()){
                if(num %100 ==0){
                    System.out.println(num + " is 100的倍数");
                }
                num++;
            }
            try {
                Thread.sleep(5000);//执行完运算之后，等待1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
