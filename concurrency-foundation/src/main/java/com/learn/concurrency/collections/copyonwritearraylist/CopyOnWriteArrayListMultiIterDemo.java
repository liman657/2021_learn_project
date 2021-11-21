package com.learn.concurrency.collections.copyonwritearraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:多个迭代器的数据决定因素
 */
@Slf4j
public class CopyOnWriteArrayListMultiIterDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> nums = new CopyOnWriteArrayList<Integer>(new Integer[]{1,2,3});
        Iterator<Integer> iteratorOne = nums.iterator();
        System.out.println(nums);//1,2,3
        nums.add(5);
        System.out.println(nums);//1,2,3,5
        Iterator<Integer> iteratorTwo = nums.iterator();
        iteratorOne.forEachRemaining(System.out::print);//1,2,3
        System.out.println();
        iteratorTwo.forEachRemaining(System.out::print);//1,2,3,5
    }
}