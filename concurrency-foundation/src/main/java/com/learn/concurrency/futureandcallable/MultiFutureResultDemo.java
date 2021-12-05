package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021-12-01
 * comment:多个Future任务获取结果，接受批量结果
 */
@Slf4j
public class MultiFutureResultDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        ArrayList<Future> resultFutureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = threadPool.submit(new CallableTask());
            resultFutureList.add(future);
        }

        //汇总输出结果，这里也可以做一些汇总的处理，比如求和什么的
        resultFutureList.stream().forEach(t->{
            try {
                System.out.println(t.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //关闭线程池
        threadPool.shutdown();
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(100);
        }
    }
}
