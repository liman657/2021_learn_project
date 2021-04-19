package com.learn.springsourcedemo.demo.generic;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/19
 * comment:
 */
@Slf4j
public class SimpleDemo {

    public static void main(String[] args) {
//        List linkList = new LinkedList();
//        linkList.add("words");
//        linkList.add(1);
//        for(int i=0;i<linkList.size();i++){
//            System.out.println(linkList.get(i));
//        }
        GenericClassDemo<String> genericClassDemo = new GenericClassDemo<String>("simpleGenericTest");
        GenericClassDemo<Integer> integerGenericClassDemo = new GenericClassDemo<Integer>(5);
        GenericClassDemo<Number> numberGenericClassDemo = new GenericClassDemo<Number>(10);
        log.info("{}",genericClassDemo.getMember().getClass());
        log.info("{}",integerGenericClassDemo.getMember().getClass());
        log.info("泛型类中普通方法的调用结果：{}",integerGenericClassDemo.sayHello("target"));

        //两个类型并没有任何差异
        log.info("泛型信息会在编译之后被擦除:{},{}",genericClassDemo.getClass(),integerGenericClassDemo.getClass());
        //TODO:能否传入与Integer有继承关系的类型
        handlerGenericClass(integerGenericClassDemo);
        //handlerGenericClass(numberGenericClassDemo);//如果方法严格定义为Integer类型的泛型类，则这里会报错
        handlerCommonGenericClass(numberGenericClassDemo);

        Integer[] integers = {1,2,3,4,5};
        Double[] doubles = {1.2,2.3,3.3,5.5};
        GenericClassDemo.printArray(integers);
        GenericClassDemo.printArray(doubles);
    }

    public static void handlerGenericClass(GenericClassDemo<Integer> integerGenericClassDemo) {
        int result = 120+integerGenericClassDemo.getMember();
        log.info("处理整型的泛型类结果为:{}",result);
    }

    /**
     * 参数的泛型要求改成了？，？表示任何支持任何类型的泛型，但是不具备类型校验的功能
     * @param numberGenericClassDemo
     */
    public static void handlerCommonGenericClass(GenericClassDemo<?> numberGenericClassDemo){
        int result = 120+(Integer)numberGenericClassDemo.getMember();
        log.info("处理通用类型的泛型，结果为:{}",result);
    }

    /**
     * 参数的泛型要求改成了？，加入了泛型类型的限制（加入泛型的上边界）
     * @param numberGenericClassDemo
     */
    public static void handlerCommonUpGenericClass(GenericClassDemo<? extends Number> numberGenericClassDemo){
        int result = 120+(Integer)numberGenericClassDemo.getMember();
        log.info("处理通用类型的泛型，结果为:{}",result);
    }

    /**
     * 参数的泛型要求改成了？，加入了泛型类型的限制（加入泛型的下边界）
     * ？ super E ，表示E必须是？的子类
     * @param numberGenericClassDemo
     */
    public static void handlerCommonDownGenericClass(GenericClassDemo<? super Integer> numberGenericClassDemo){
        int result = 120+(Integer)numberGenericClassDemo.getMember();
        log.info("处理通用类型的泛型，结果为:{}",result);
    }
}
