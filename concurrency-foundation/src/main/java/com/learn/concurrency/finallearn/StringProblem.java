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
        String strA = "hello2";
        final String strB = "hello";
        String strC = "hello";
        String strD = strB+2;
        String strE = strC+2;
        System.out.println((strA == strD));
        System.out.println((strA == strE));
    }

    public static void testStrDemo2(){
        String strA = "demo2";
        final String strB = getDemoStr();
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
