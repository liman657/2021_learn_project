package com.learn.concurrency.finallearn;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:Final的Person类
 * 其他类都无法修改这个类的属性，即使是public也不行
 */
@Slf4j
public class FinalPersonDemo {

    public final int age = 18;
    public final String name = "Alice";
}
