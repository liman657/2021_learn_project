package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在03的基础上缩小Synchronized的修饰范围
 */
@Slf4j
public class SynchronizedSmallCacheDemo_04<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<A,V>();

    private final Computable<A,V> computable;

    public SynchronizedSmallCacheDemo_04(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(arg);
        if(null == result){
            //具体的计算通过接口定义，实现抽象
            result = computable.compute(arg);
            //缩小Synchronized的保护范围，但这依旧是数据不安全的
            synchronized (this) {
                cache.put(arg, result);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        SynchronizedSmallCacheDemo_04<String, Integer> testComputer = new SynchronizedSmallCacheDemo_04<>(
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
