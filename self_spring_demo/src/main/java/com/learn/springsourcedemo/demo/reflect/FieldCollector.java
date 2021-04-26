package com.learn.springsourcedemo.demo.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021/4/26
 * comment: 反射获取字段信息，获取成员变量并调用
 *
 * 1、批量的
 *  Field[] getFields() 获取所有的公有字段
 *  Field[] getDeclaredFields(); 获取所有字段，包括：私有、受保护、默认、公有
 * 2、获取单个的
 *  public Field getField(String fieldName):获取某个"公有的"字段
 *  public Field getDeclaredField(String fieldName):获取某个字段（可以是私有的）
 *
 *  设置字段的值
 *   Field --> public void set(Object obj,Object value);
 *      参数说明：1、obj要设置的字段所在的对象
 *              2、value:要为字段设置的值
 *
 * 需要说明的是 getFields和getField可获取父类的相关的字段，而 getDeclaredFields和getDeclaredField是无法获取任何父类的字段
 */
@Slf4j
public class FieldCollector {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取class对象
        Class reflectTargetClass = Class.forName("com.learn.springsourcedemo.demo.reflect.ReflectTarget");
        //1.获取所有公有的字段
        log.info("*************获取所有的公有字段***************");
        Field[] fieldArray = reflectTargetClass.getFields();
        Stream.of(fieldArray).forEach(System.out::println);

        //2.获取所有公有的字段
        log.info("*************获取所有的字段***************");
        Field[] fieldArrayAll = reflectTargetClass.getDeclaredFields();
        Stream.of(fieldArrayAll).forEach(System.out::println);

        //3.获取所有公有的字段
        log.info("*************获取指定的公有字段***************");
        Field field = reflectTargetClass.getField("name");
        Stream.of(field).forEach(System.out::println);
        ReflectTarget reflectTarget = (ReflectTarget) reflectTargetClass.getConstructor().newInstance();
        field.set(reflectTarget,"反射字段一号");
        log.info("验证结果:{}",reflectTarget.name);

        //4.获取单个是有的field
        log.info("*************获取指定的任意字段***************");
        Field fieldAny = reflectTargetClass.getDeclaredField("targetInfo");
        Stream.of(field).forEach(System.out::println);
        ReflectTarget reflectTargetAny = (ReflectTarget) reflectTargetClass.getConstructor().newInstance();
        fieldAny.setAccessible(true);
        fieldAny.set(reflectTargetAny,"反射字段任意号");
        log.info("验证结果:{}",reflectTargetAny.toString());
    }
}
