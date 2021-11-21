package com.learn.concurrency.collections.copyonwritearraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:CopyOnWriteArrayList 使用实例
 */
@Slf4j
public class CopyOnWriteArrayListUseDemo {

    public static void main(String[] args) {
//        ordinalListDemo();
        copyOnWriteArrayListDemo();
    }

    public static void ordinalListDemo(){
        ArrayList<String> oridinalList = new ArrayList<>();
        oridinalList.add("1");
        oridinalList.add("2");
        oridinalList.add("3");
        oridinalList.add("4");
        oridinalList.add("5");
        Iterator<String> iterator = oridinalList.iterator();
        while (iterator.hasNext()) {
            System.out.println("oridinalList is " + oridinalList);
            String next = iterator.next();//删除"5"之后，下次迭代会抛异常
            System.out.println("current node is " + next);
            if (next.equals("2")) {
                oridinalList.remove("5");//这里在遍历的时候对集合进行修改，这会抛异常的
            }
        }
    }

    /**
     * CopyOnWriteArrayList的实例
     */
    public static void copyOnWriteArrayListDemo(){
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        copyOnWriteArrayList.add("4");
        copyOnWriteArrayList.add("5");
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println("oridinalList is " + copyOnWriteArrayList);
            String next = iterator.next();
            System.out.println("current node is " + next);
            if (next.equals("2")) {
                copyOnWriteArrayList.remove("5");//copyOnWriteArrayList不会抛错
            }

            if(next.equals("3")){
                copyOnWriteArrayList.add("new node");
            }
        }
    }
}
