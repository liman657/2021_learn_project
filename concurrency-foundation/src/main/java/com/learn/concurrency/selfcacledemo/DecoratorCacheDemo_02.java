package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:装饰者模式给计算器自动添加缓存功能
 */
@Slf4j
public class DecoratorCacheDemo_02<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<A,V>();

    private final Computable<A,V> computable;

    public DecoratorCacheDemo_02(Computable<A, V> computable) {
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
        DecoratorCacheDemo_02<String, Integer> testComputer = new DecoratorCacheDemo_02<>(
                new ExpensiveFunction());
        Integer result = testComputer.compute("666");
        System.out.println("第一次计算结果："+result);
        result = testComputer.compute("666");
        System.out.println("第二次计算结果："+result);
    }
}
