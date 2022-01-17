package com.learn.java8.stream_chapter03;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021-12-15
 * comment:Stream的迭代器
 * 流的创建
 */
@Slf4j
public class SteamIterate {

    public static void main(String[] args) {

        //1、Stream.of创建流，从数据源创建流
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));
        System.out.println(names);

        //2、利用 Arrays.stream 方法创建流
        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(","));
        System.out.println(names);

        //static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
        //返回一个无限顺序的有序流（infinite sequential,ordered stream），它由迭代应用到初始元素种子的函数 f 产生
        //UnaryOperator，它是一种函数式接口，其输入参数和输出类型相同。
        //如果有办法根据当前值生成流的下一个值， iterate 方法将相当有用
        List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE)).limit(10).collect(Collectors.toList());
        log.info("iterate nums : {}", nums);
        List<LocalDate> days = Stream.iterate(LocalDate.now(), t -> t.plusDays(1L)).limit(10).collect(Collectors.toList());
        log.info("iterate days:{}", days);

        //3、利用 Stream.generate 方法创建流
        //static <T> Stream<T> generate(Supplier<T> s)
        //generate 方法通过多次调用 Supplier 产生一个顺序的无序流
        long count = Stream.generate(Math::random).limit(10).count();

        //4、从集合创建流
        List<String> bradyBunch = Arrays.asList("Greg", "Marcia", "Peter", "Jan",
                "Bobby", "Cindy");
        names = bradyBunch.stream()
                .collect(Collectors.joining(","));
        System.out.println(names);

        //5、装箱和拆箱，range 和 rangeClosed 方法
        List<Integer> ints = IntStream.range(10, 15)
                .boxed()//如果没有boxed，直接通过Collectors.toList则会编译报错
                .collect(Collectors.toList());
        System.out.println(ints);

        List<Integer> newInts = IntStream.range(10, 15)
                .mapToObj(Integer::valueOf)//也可以使用mapToObj的方式完成装箱
                .collect(Collectors.toList());
        System.out.println(newInts);

        //除了上述两种方法，还可以通过三参数的collect方法完成装箱
        List<Integer> threeParamArrayList = IntStream.range(10, 15)
                //三个参数，分别是用于填充的集合、为集合添加单个元素的累加器以及为集合
                //添加多个元素的组合器。
                .collect(ArrayList<Integer>::new,ArrayList::add,ArrayList::addAll);
        System.out.println(threeParamArrayList);

        List<Long> longs = LongStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longs);

        //直接将intStream转换成数组
        int[] intArray = IntStream.range(10, 15).toArray();

    }
}