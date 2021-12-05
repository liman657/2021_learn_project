package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import com.learn.concurrency.selfcacledemo.computable.SelfFailFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在07的基础上，模拟计算抛出异常的场景
 */
@Slf4j
public class CalFailCacheDemo_08<A, V> implements Computable<A, V> {
    //Future只是对有线程返回结果的一个包装
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> computable;

    public CalFailCacheDemo_08(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws Exception {
//        System.out.println("进入缓存机制");
        while(true) {
            Future<V> futureResult = cache.get(arg);
            if (futureResult == null) {
                Callable callable = new Callable<V>() {

                    @Override
                    public V call() throws Exception {
                        return computable.compute(arg);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<>(callable);
                //在正式调用计算方法之前，由于ConcurrentHashMap是线程安全的可以保证可见性。
                futureResult = cache.put(arg, futureTask);
                if (null == futureResult) {
                    futureResult = futureTask;
                    String currentThread = Thread.currentThread().getName();
                    System.out.println(currentThread+"从FutureTask调用了计算函数");
                    //真正开始调用计算
                    futureTask.run();
                }
            }
            //get获取结果的时候，如果目标线程的结果没有计算完毕，会阻塞
            try {
                return futureResult.get();
            } catch (CancellationException e) {
                System.out.println("取数任务被取消");
                //避免缓存被污染，一定要删除缓存中的内容
                cache.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                System.out.println("取数任务被中断");
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                String currentThreadName = Thread.currentThread().getName();
                System.out.println(currentThreadName+"计算失误，需要重试");
                cache.remove(arg);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CalFailCacheDemo_08<String, Integer> testComputer = new CalFailCacheDemo_08<>(
                new SelfFailFunction());
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
