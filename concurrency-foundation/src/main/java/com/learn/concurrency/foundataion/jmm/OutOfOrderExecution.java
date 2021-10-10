package com.learn.concurrency.foundataion.jmm;

import lombok.extern.slf4j.Slf4j;

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
        int count = 0;
        for (; ; ) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Thread oneThread = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread twoThread = new Thread(() -> {
                b = 1;
                y = a;
            });
            oneThread.start();
            twoThread.start();
            oneThread.join();
            twoThread.join();

            if(canComplete(x,y)){
                log.info("第:{}次，a:{},b:{},x:{},y:{}", count,a, b, x, y);
                break;
            }
            log.info("第:{}次，a:{},b:{},x:{},y:{}",count, a, b, x, y);
            count++;
        }
    }

    public static boolean canComplete(int x,int y){
        if(x ==1 && y == 1){
            return true;
        }
        return false;
    }
}