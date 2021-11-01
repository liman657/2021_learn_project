package com.learn.concurrency.juclearn.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021-11-01
 * comment: newFixedThreadPool出现OOM的实例
 * JVM 参数 -Xmx8m -Xms8m
 */
public class FixThreadPoolOOM {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
      for(int i=0;i<Integer.MAX_VALUE;i++){
          executorService.execute(new OOMTask());
      }
    }

}

class OOMTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}