package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * autor:liman
 * createtime:2021-12-01
 * comment:演示一个future的使用方法，lambda表达式
 */
@Slf4j
public class OneFutureLambdaDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };
        Future<Integer> result = executorService.submit(callable);
        try{
            System.out.println(result.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}