package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * autor:liman
 * createtime:2021-12-01
 * comment:演示一个Future的使用方法
 */
@Slf4j
public class OneFutureDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //线程池的submit接受实现了Callable接口的方法
        Future<Integer> future = service.submit(new CallableTask());
        try{
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class CallableTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
