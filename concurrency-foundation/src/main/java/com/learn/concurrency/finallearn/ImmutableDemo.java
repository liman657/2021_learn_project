package com.learn.concurrency.finallearn;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:完整的不可变对象
 * 外部在拿到ImmutableDemo的对象的时候，是无法修改其中的属性nameList的值的。
 */
@Slf4j
public class ImmutableDemo {

    private final Set<String> nameList = new HashSet<>();

    public ImmutableDemo() {
        nameList.add("Tom");
        nameList.add("Peter");
        nameList.add("Jerry");
    }

    public boolean isExist(String name){
        return nameList.contains(name);
    }
}
