package com.learn.springsourcedemo.demo.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment: 构造函数收集器
 * 通过获取Class对象，可以获取构造方法
 * 1、批量的获取方法
 *  public Constructor[] getConstructors();
 *  public Constructor[] getDeclaredConstructors();
 * 2、获取单个的构造方法，并调用
 *  public Constructor getConstructor(Class... parameterTypes); 获取单个的，公有的构造函数
 *  public Constructor getDeclaredConstructor(Class... parameterTypes); 获取"某个构造方法"，可以是私有的、受保护的，公有的
 *
 * 调用构造方法
 * Constructor -> newInstance(Object... initargs);
 */
@Slf4j
public class ConstructorCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.learn.springsourcedemo.demo.reflect.ReflectTarget");

        //1、获取所有公有的构造方法
        log.info("===============获取所有公有的构造方法======================");
        Constructor[] connArrays = clazz.getConstructors();
        for(Constructor constructor:connArrays){
            log.info("{}",constructor);
        }

        //2、获取所有的构造方法
        log.info("===============获取所有的构造方法======================");
        Constructor[] allConstructorMethod = clazz.getDeclaredConstructors();
        for(Constructor constructor:allConstructorMethod){
            log.info("{}",constructor);
        }

        //3、获取指定的带有参数的构造方法
        log.info("===============获取指定的带有参数的构造方法======================");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        log.info("{}",constructor);

        //3、获取指定的私有的构造方法
        log.info("===============获取指定的私有的带有参数的构造方法======================");
        Constructor privateConstructor = clazz.getDeclaredConstructor(int.class);
        log.info("{}",privateConstructor);

        //调用私有的构造函数
        privateConstructor.setAccessible(true);//强制访问私有的构造函数
        ReflectTarget reflectTarget = (ReflectTarget) privateConstructor.newInstance(1);

    }

}
