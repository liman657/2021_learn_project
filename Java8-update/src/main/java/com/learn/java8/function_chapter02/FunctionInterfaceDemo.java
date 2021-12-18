package com.learn.java8.function_chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * autor:liman
 * createtime:2021/11/27
 * comment:Function接口实例
 */
@Slf4j
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        List<Integer> nameLengths = names.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).collect(Collectors.toList());

        nameLengths = names.stream().map(s->s.length()).collect(Collectors.toList());//lambda表达式
        nameLengths = names.stream().map(String::length).collect(Collectors.toList());//方法引用
        log.info("nameLengths values : {}",nameLengths);
    }

}
