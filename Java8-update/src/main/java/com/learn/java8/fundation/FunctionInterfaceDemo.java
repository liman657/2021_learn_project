package com.learn.java8.fundation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * autor:liman
 * createtime:2021-11-25
 * comment:函数式接口
 * <p>
 * 1.8之后，接口中可以增加静态方法
 * 接口中的静态方法只需通过接口名直接调用静态方法即可。
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore"
                , "Dalton", "Brosnan", "Craig");
        List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sorted);
        List<String> reverseOrder = bonds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseOrder);
        reverseOrder = bonds.stream().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
        System.out.println(reverseOrder);
    }

}
