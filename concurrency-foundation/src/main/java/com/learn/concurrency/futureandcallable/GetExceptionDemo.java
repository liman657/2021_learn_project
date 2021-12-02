package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021-12-02
 * comment：演示get方法过程中抛出异常的处理
 */
@Slf4j
public class GetExceptionDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Future<Integer> result = threadPool.submit(new CallableTask());
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(5000);
            }
            boolean done = result.isDone();//返回对应的结果线程是否执行完毕
            System.out.println("isDone:"+done);
            result.get();//只有当执行get的时候，才能抛出异常，其实内部的异常早就已经发生了，只是在get的时候抛出异常
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
            ex.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            throw new IllegalArgumentException("callable抛出exception");
        }
    }

}
