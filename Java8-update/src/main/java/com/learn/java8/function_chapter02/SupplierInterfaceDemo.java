package com.learn.java8.function_chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;

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

        List<String> names = Arrays.asList("Mal","Wash","Kaylee","Inara","Zoë", "Jayne", "Simon", "River", "Shepherd Book");
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

    }

}
