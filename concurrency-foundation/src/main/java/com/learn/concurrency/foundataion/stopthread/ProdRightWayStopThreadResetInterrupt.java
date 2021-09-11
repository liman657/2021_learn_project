package com.learn.concurrency.foundataion.stopthread;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:生产中正确的停止线程的方式之一：在子方法中重新通知中断
 * 在catch语句中重新通知中断
 */
@Slf4j
public class ProdRightWayStopThreadResetInterrupt implements Runnable {
    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()){
                log.info("thread is interrupted，线程中断，运行终止");
                break;
            }
            System.out.println("running");
            catchInterruptInMethod();
        }

    }

    private void catchInterruptInMethod() {
        //线程的调用方法中，sleep的时候针对中断异常的处理并没有抛出
        //sleep模拟子线程在运行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("收到中断信号，处理中断，信息为:{}",e);
            //重新通知中断，在父run方法中，正常响应中断即可。
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ProdRightWayStopThreadResetInterrupt());
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }
}
