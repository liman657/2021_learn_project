package com.learn.concurrency.juclearn.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * autor:liman
 * createtime:2021/11/16
 * comment:LongAdder累加器实例
 * LongAdder比AtomicLong效率要好
 */
@Slf4j
public class AtomicLongDemo {

    public static void main(String[] args) {
        AtomicLong atomicLongCounter = new AtomicLong(0);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Task(atomicLongCounter));
        }
        //判断线程池是否停止
        executorService.shutdown();
        while(!executorService.isTerminated()){
            //线程池没有执行完成任务，主线程就空转
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时"+(endTime-startTime));
        System.out.println(atomicLongCounter.get());

    }

    private static class Task implements Runnable{

        private AtomicLong atomicLongCounter;

        public Task(AtomicLong atomicLongCounter) {
            this.atomicLongCounter = atomicLongCounter;
        }

        @Override
        public void run() {
            for(int i=0;i<10000;i++){
                atomicLongCounter.incrementAndGet();
            }
        }
    }

}
