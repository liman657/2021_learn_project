package com.learn.concurrency.selfcacledemo.computable;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:内部提供计算函数，用来代表耗时计算，与缓存独立，每个计算器都需要实现这个接口
 */
public interface Computable<A,V> {

    /**
     * 计算方法，A参数，V返回值
     * @param arg
     * @return
     * @throws Exception
     */
    V compute(A arg) throws Exception;


}
