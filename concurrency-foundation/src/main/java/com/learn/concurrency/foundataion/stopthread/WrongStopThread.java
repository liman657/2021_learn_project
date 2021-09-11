package com.learn.concurrency.foundataion.stopthread;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:利用stop暴力停止线程的方法，会导致线程运行一半 突然停止，出现脏数据
 * 模拟：军队发放弹药
 */
@Slf4j
public class WrongStopThread implements Runnable {


    @Override
    public void run() {
        int length = 5;
        for (int i = 0; i < length; i++) {
            log.info("连队：{}，开始领取弹药",i+1);
            for(int j=0;j<60;j++){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("连队：{}，中的第：{}号士兵领取枪支弹药完毕",i+1,j+1);
            }
            log.info("连队:{},弹药分发完毕",i+1);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new WrongStopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
