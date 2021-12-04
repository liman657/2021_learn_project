package com.learn.concurrency.selfcacledemo.computable;

import lombok.extern.slf4j.Slf4j;


/**
 * autor:liman
 * createtime:2021/12/4
 * comment:一个耗时计算的实现类，实现了Computeable接口
 * 但是本身不具备缓存的能力，不需要考虑缓存的事情
 */
@Slf4j
public class ExpensiveFunction implements Computable<String,Integer>{
    @Override
    public Integer compute(String arg) throws Exception {
        log.info("底层开始计算数据结果");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Integer result = Integer.valueOf(arg);
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        log.info("缓存计算方法耗时:{}", costTime);
        return result;
    }
}
