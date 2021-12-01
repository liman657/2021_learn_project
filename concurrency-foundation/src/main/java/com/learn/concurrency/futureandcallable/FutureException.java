package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * autor:liman
 * createtime:2021-12-01
 * comment:Future抛出异常的处理
 * Future抛出异常是有时机的，并不是一产生异常就抛出
 */
@Slf4j
public class FutureException {

    public static void main(String[] args) {

    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(100);
        }
    }

}
