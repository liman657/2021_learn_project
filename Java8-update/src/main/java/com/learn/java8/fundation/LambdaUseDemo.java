package com.learn.java8.fundation;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * autor:liman
 * createtime:2021-11-22
 * comment:Lambda表达式的学习
 */
@Slf4j
public class LambdaUseDemo {

    public static void main(String[] args) {
        String path = "F:\\2021_learn_project\\foundation-demo\\src\\main\\java\\com\\learn\\sample";
        File dir = new File(path);
        //lambda 初始化一个FilenameFilter的实例
        String[] javaFileList = dir.list((filePath, name) -> name.endsWith(".java"));

        //这个就是方法引用
        Arrays.asList(javaFileList).stream().forEach(System.out::println);
        //方法引用赋值给函数式接口
        Consumer<String> printer = System.out::println;
        Arrays.asList(javaFileList).stream().forEach(printer);
    }

}
