package com.learn.concurrency.selfcacledemo.computable;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * autor:liman
 * createtime:2021/12/5
 * comment:模拟计算失败的情况
 */
@Slf4j
public class SelfFailFunction implements Computable<String,Integer>{

    @Override
    public Integer compute(String arg) throws Exception {
        double random = Math.random();
        if (random > 0.5) {
            throw new IOException("读取文件出错");
        }
        Thread.sleep(3000);
        return Integer.valueOf(arg);
    }
}
