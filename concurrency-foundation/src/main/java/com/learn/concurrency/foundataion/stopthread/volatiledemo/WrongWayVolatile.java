package com.learn.concurrency.foundataion.stopthread.volatiledemo;

import com.learn.concurrency.foundataion.stopthread.WrongStopThread;
import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment: volatile的局限性
 */
@Slf4j
public class WrongWayVolatile implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    log.info("num : {} 是100的倍数", num);
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile runThread = new WrongWayVolatile();
        Thread thread = new Thread(runThread);
        thread.start();
        Thread.sleep(10000);
        runThread.canceled = true;//类似发出中断信号，将中断标志位置为true
    }
}
