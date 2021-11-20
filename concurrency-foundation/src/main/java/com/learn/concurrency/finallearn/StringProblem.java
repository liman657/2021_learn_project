package com.learn.concurrency.finallearn;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:几个关于String恶心的面试题
 */
@Slf4j
public class StringProblem {

    public static void main(String[] args) {
//        testStrDemo1();
//        testStrDemo2();
        testStrDemo3();
    }

    public static String getDemoStr(){
        return "demo";
    }

    public static void testStrDemo1(){
        //字符串常量池中就会定义hello2
        String strA = "hello2";
        final String strB = "hello";//编译的时候就能确定值
        String strC = "hello";//字符串常量池中会定义hello，但不是hello2
        String strD = strB+2;//同样，编译的时候也能确定值
        String strE = strC+2;//运行的时候才能确定值，因此在堆上建立对象
        System.out.println((strA == strD));
        System.out.println((strA == strE));
    }

    public static void testStrDemo2(){
        String strA = "demo2";
        final String strB = getDemoStr();//运行时才能确定值
        String strC = "demo";
        String strD = strB+2;
        String strE = strC+2;
        System.out.println((strA == strD));
        System.out.println((strA == strE));
    }

    public static void testStrDemo3(){
        String strA = "demo3";
        final String strB = "demo";
        String strC = "demo";
        String strD = strB+3;
        String strE = strC+3;
        String strF = new String("demo");
        String strG = strF+3;
        System.out.println((strA == strD));//true
        System.out.println((strA == strE));//false
        System.out.println((strB == strF));//false
        System.out.println((strA == strF));//false
        System.out.println((strC == strF));//strC="demo"也是在编译期间确定的
    }
}
