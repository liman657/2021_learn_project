package com.learn.java8.fundation;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        /**
         * object::instanceMethod 引用特定对象的实例方法，如 System.out::println
         * Class::staticMethod 引用静态方法，如 Math::max。
         * Class::instanceMethod 调用特定类型的任意对象的实例方法，如 String::length。
         */
        //方法引用也可以和静态方法一起使用
        //这里的Math::random就是静态方法
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        List<String> stringList = Arrays.asList("this", "is", "a", "list", "of", "strings");
        //普通的比较写法
        //List<String> sortedList = stringList.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
        //用方法引用的写法
        List<String> sortedList = stringList.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedList);

        List<Integer> allStrLength = stringList.stream().sorted(String::compareTo).map(String::length).collect(Collectors.toList());
        System.out.println(allStrLength);
    }

}
