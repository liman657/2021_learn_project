package com.learn.concurrency.foundataion.jmm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * autor:liman
 * createtime:2021/10/8
 * comment:重排序的实例
 * 直到达到某个条件才停止
 */
@Slf4j
public class OutOfOrderExecution {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int count = 0;
        for (; ; ) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            //线程1 a=1,x=b
            Thread oneThread = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                x = b;
            });
            //线程2 b=1,y=a
            Thread twoThread = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
                y = a;
            });
            oneThread.start();
            twoThread.start();
            countDownLatch.countDown();
            oneThread.join();
            twoThread.join();

            if(canComplete(x,y)){
                log.info("第{}次，a:{},b:{},x:{},y:{}", count,a, b, x, y);
                break;
            }
            log.info("第{}次，a:{},b:{},x:{},y:{}",count, a, b, x, y);
            count++;
        }
    }

    public static boolean canComplete(int x,int y){
        if(x ==0 && y == 0){
            return true;
        }
        return false;
    }
}