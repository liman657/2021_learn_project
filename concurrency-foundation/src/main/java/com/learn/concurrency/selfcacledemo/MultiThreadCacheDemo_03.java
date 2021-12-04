package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在02的基础上模拟多线程的耗时问题
 * 定义了三个线程，第三个线程是获取第一次已经计算得出的结果，不应该等待很久，但是因为synchronized修饰了，所以依旧要等待很久
 */
@Slf4j
public class MultiThreadCacheDemo_03<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<A,V>();

    private final Computable<A,V> computable;

    public MultiThreadCacheDemo_03(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public synchronized V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(arg);
        if(null == result){
            //具体的计算通过接口定义，实现抽象
            result = computable.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        MultiThreadCacheDemo_03<String, Integer> testComputer = new MultiThreadCacheDemo_03<>(
                new ExpensiveFunction());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = testComputer.compute("666");
                    System.out.println("第一次的计算结果："+result);
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
                    System.out.println("第三次的计算结果："+result);
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
                    System.out.println("第二次的计算结果："+result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
