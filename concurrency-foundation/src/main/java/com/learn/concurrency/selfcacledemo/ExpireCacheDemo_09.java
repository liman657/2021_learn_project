package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.SelfFailFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在08的基础上，引入缓存超时失效的机制
 */
@Slf4j
public class ExpireCacheDemo_09<A, V> implements Computable<A, V> {
    //Future只是对有线程返回结果的一个包装
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    //处理缓存失效的线程池
    public final static ScheduledExecutorService expireThreadPool = Executors.newScheduledThreadPool(5);

    private final Computable<A, V> computable;

    public ExpireCacheDemo_09(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws Exception {
        while (true) {
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
                futureResult = cache.putIfAbsent(arg, futureTask);
                if (null == futureResult) {
                    futureResult = futureTask;
                    String currentThread = Thread.currentThread().getName();
                    System.out.println(currentThread + "从FutureTask调用了计算函数");
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
                System.out.println(currentThreadName + "计算失误，需要重试");
                cache.remove(arg);
            }
        }
    }

    public V compute(A arg, long expire) throws Exception {
        if (expire > 0) {
            //这里利用定时任务的线程池，到了指定的时间，就执行指定的任务，在指定的任务中，执行清除逻辑
            expireThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            }, expire, TimeUnit.MILLISECONDS);
        }
        //如果没有指定
        return compute(arg);
    }

    public synchronized void expire(A key) {
        Future<V> future = cache.get(key);
        if (null != future) {
            if (!future.isDone()) {//如果任务没完成，到了过期时间，则先判断任务是否完毕，如果没有完毕，则直接取消
                System.out.println("future任务被取消");
                future.cancel(true);
            }
            System.out.println("过期时间到，缓存被清除");
            cache.remove(key);
        }
    }


    public static void main(String[] args) throws Exception {
        ExpireCacheDemo_09<String, Integer> testComputer = new ExpireCacheDemo_09<>(
                new SelfFailFunction());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = testComputer.compute("666",5000L);
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

        Thread.sleep(6000L);
        Integer result = testComputer.compute("666");
        System.out.println("主线程的计算结果：" + result);
    }
}
