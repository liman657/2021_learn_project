package com.learn.concurrency.finallearn;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:final 修饰变量的几种情况
 */
@Slf4j
public class FinalVariableDemo {


    private static final int age;

    static{
        age = 10;
    }

    public void finalValiableMethod(){
        final int test;
        int b = 0;
        b++;
        test = 2;
        b += test;
    }

}
