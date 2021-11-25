package com.learn.java8.fundation;

/**
 * autor:liman
 * createtime:2021-11-25
 * comment:回文检查器的函数式接口
 */
@FunctionalInterface
public interface PalindromeChecker {
    boolean isPalidrome(String text);
}
