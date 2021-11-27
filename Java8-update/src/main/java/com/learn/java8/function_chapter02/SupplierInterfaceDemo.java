package com.learn.java8.function_chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

/**
 * autor:liman
 * createtime:2021-11-25
 * comment:Supplier函数式接口的实例
 * T get();
 */
@Slf4j
public class SupplierInterfaceDemo {

    public static void main(String[] args) {
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        //lambda表达式
        randomSupplier = ()->Math.random();
        //方法引用
        randomSupplier = Math::random;
        System.out.println(randomSupplier);

        //Optional中定义的orElseGet方法，同样传入Supplier
        List<String> names = Arrays.asList("Mal","Wash","Kaylee","Inara","Zoë", "Jayne", "Simon", "River", "Shepherd Book");
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();
        System.out.println(first.orElse("None"));

        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));

        //orElseGet 方法传入 Supplier 作为参数。
        //Optional 类的 orElseThrow 方法传入 Supplier<X extends Exception>，仅当发生异常时才会执行 Supplier。传入的泛型为返回值
        System.out.println(first.orElseGet(() ->
                String.format("No result found in %s",
                        names.stream().collect(Collectors.joining(", ")))));

    }

}
