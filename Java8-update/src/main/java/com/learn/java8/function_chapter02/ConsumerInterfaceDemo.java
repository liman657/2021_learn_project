package com.learn.java8.function_chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * autor:liman
 * createtime:2021-11-25
 * comment:Consumer函数式接口的实例
 */
@Slf4j
public class ConsumerInterfaceDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this","is","a","list","of","strings");

        strings.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        strings.stream().forEach(System.out::println);
        strings.stream().forEach(s-> System.out.println(s));
    }

}
