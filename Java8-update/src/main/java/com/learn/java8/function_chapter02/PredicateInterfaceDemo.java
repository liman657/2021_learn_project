package com.learn.java8.function_chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021/11/27
 * comment:Predicate函数接口实例
 * 主要功能：流的筛选
 * Stream 接口的 filter 方法传入 Predicate 并返回一个新的流
 */
@Slf4j
public class PredicateInterfaceDemo {
    //长度为5
    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    //以s开头
    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

    public static void main(String[] args) {
        String[] names = Stream.of("Mal", "Wash", "Kaylee", "Inara", "Zoë",
                "Jayne", "Simon", "River", "Shepherd Book").sorted().toArray(String[]::new);
        testDuplicatePredicate(names);
    }

    /**
     * 返回以给定字符串开头的字符串
     * @param length
     * @param names
     * @return
     */
    public static String getNamesOfLength(int length,String... names){
        return Arrays.stream(names).filter(s->s.length() == length)
                .collect(Collectors.joining(", "));
    }

    /**
     * 返回以给定字符串开头的字符串
     * @param s
     * @param names
     * @return
     */
    public static String getNamesStartingWith(String s,String... names){
        return Arrays.stream(names)
                .filter(name->name.startsWith(s))
                .collect(Collectors.joining(", "));
    }

    /**
     * 测试复合谓词
     */
    public static void testDuplicatePredicate(String... names){
        String andFilterResult = Arrays.stream(names).filter(LENGTH_FIVE.and(STARTS_WITH_S)).collect(Collectors.joining(", "));
        String orFilterResult = Arrays.stream(names).filter(LENGTH_FIVE.or(STARTS_WITH_S)).collect(Collectors.joining(", "));

        String negateResult = Arrays.stream(names).filter(LENGTH_FIVE.negate()).collect(Collectors.joining(", "));
        System.out.println(andFilterResult);
        System.out.println(orFilterResult);
        System.out.println(negateResult);
    }

}
