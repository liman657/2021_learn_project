package com.learn.springsourcedemo.demo.generic;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/19
 * comment: 泛型类实例 <T>既是声明
 * 基础数据不能作为泛型的参数
 * 泛型的相关信息不会进入到运行时阶段
 */
@Data
@Slf4j
public class GenericClassDemo<T> {

    private T member;

    public GenericClassDemo(T member) {
        this.member = member;
    }

    public T handleSomething(T target){
        return target;
    }

    public String sayHello(String target){
        return "hello : "+target;
    }

    /**
     * 泛型方法，没有<E>这种泛型声明的方法，都是普通方式
     * 泛型方法的标识符，不受制于类的标识符
     * 泛型方法的标识符可以于类的标识符一样，但是二者完成独立
     * @param array
     * @param <E>
     */
    public static <E> void printArray(E[] array){
        for(E e:array){
            log.info("泛型方法打印元素：{}",e);
        }
    }
}
