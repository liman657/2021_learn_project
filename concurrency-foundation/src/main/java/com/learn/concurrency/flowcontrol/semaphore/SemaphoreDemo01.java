package com.learn.concurrency.flowcontrol.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:多个线程等待许可证
 */
public class SemaphoreDemo01 {

    static Semaphore semaphore = new Semaphore(3, true);//3个许可证，公平模式

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        //判断线程池是否停止
        executorService.shutdown();
        while(!executorService.isTerminated()){
            //线程池没有执行完成任务，主线程就空转，直到线程池运行结束
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
                semaphore.acquire(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了许可证");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            semaphore.release(3);
            System.out.println(Thread.currentThread().getName() + "释放了许可证");
        }
    }
}
