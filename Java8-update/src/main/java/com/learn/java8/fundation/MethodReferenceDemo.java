package com.learn.java8.fundation;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021-11-22
 * comment:方法引用的实例
 */
@Slf4j
public class MethodReferenceDemo {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6).forEach(System.out::println);

        //方法引用也可以和静态方法一起使用
        //这里的Math::random就是静态方法
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
