package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.futureandcallable.FutureTaskDemo;
import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在05的基础利用Future避免重复运算
 */
@Slf4j
public class FutureResultCacheDemo_06<A, V> implements Computable<A, V> {
    //Future只是对有线程返回结果的一个包装
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> computable;

    public FutureResultCacheDemo_06(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        Future<V> futureResult = cache.get(arg);
        if(futureResult == null){
            Callable callable = new Callable<V>(){

                @Override
                public V call() throws Exception {
                    return computable.compute(arg);
                }
            };
            FutureTask<V> futureTask = new FutureTask<>(callable);
            futureResult = futureTask;
            //在正式调用计算方法之前，由于ConcurrentHashMap是线程安全的可以保证可见性。
            cache.put(arg,futureTask);
            System.out.println("从FutureTask调用了计算函数");
            //真正开始调用计算
            futureTask.run();
        }
        //get获取结果的时候，如果目标线程的结果没有计算完毕，会阻塞
        return futureResult.get();
    }

    public static void main(String[] args) throws Exception {
        FutureResultCacheDemo_06<String, Integer> testComputer = new FutureResultCacheDemo_06<>(
                new ExpensiveFunction());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = testComputer.compute("666");
                    System.out.println("第一次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = testComputer.compute("667");
                    System.out.println("第三次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = testComputer.compute("666");
                    System.out.println("第二次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
