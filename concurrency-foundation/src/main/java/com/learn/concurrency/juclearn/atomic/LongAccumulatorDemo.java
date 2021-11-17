package com.learn.concurrency.juclearn.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * autor:liman
 * createtime:2021/11/16
 * comment:演示Accumulate累加器
 */
@Slf4j
public class LongAccumulatorDemo {

    public static void main(String[] args) {
        LongAccumulator accumulator = new LongAccumulator((x,y)->x+y,0);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        IntStream.rangeClosed(1,100).forEach(t->executorService.submit(()->accumulator.accumulate(t)));
        executorService.shutdown();
        //等待线程池结束，主线程自旋
        while(!executorService.isTerminated()){

        }
        System.out.println(accumulator.getThenReset());
    }
}
