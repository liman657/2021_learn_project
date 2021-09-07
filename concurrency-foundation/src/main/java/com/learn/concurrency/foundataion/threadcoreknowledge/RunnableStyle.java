package com.learn.concurrency.foundataion.threadcoreknowledge;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/7
 * comment:runnable创建线程
 */
@Slf4j
public class RunnableStyle extends Thread implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        log.info("用runnable的方式实现线程");
    }


}
