package com.learn.springsourcedemo.demo.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * autor:liman
 * createtime:2021/4/26
 * comment:反射调用成员方法的实例
 * 1、批量
 *  public Method[] getMethods();获取所有"公有方法"；（包含了父类的方法，也包含Object类中的方法）
 *  pubilc Method[] getDeclaredMethods();获取所有的成员方法，包括私有的（不包括继承的）
 * 2、获取单个的
 *  public Method getMethod(String name,Class<?>... parameterTypes);
 *      参数：
 *          name——方法名
 *          Class...形参的Class类型对象
 *
 *  public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 *  调用方法
 *      Method --> public Object invoke(Object obj,Object... args);
 *          参数：
 *              obj:要调用的方法对象
 *              args:调用方法时所传递的实参
 */
@Slf4j
public class MethodCollector {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //1、获取Class对象
        Class reflectTargetClass = Class.forName("com.learn.springsourcedemo.demo.reflect.ReflectTarget");
        //2、获取所有公有方法
        System.out.println("***************获取所有的public方法，包括父类和Object*******************");
        Method[] methodArray = reflectTargetClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        //3、获取该类的所有方法
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = reflectTargetClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        //4、获取单个公有方法
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = reflectTargetClass.getMethod("show1", String.class);
        System.out.println(m);
        //5、调用show1并执行
        ReflectTarget reflectTarget = (ReflectTarget)reflectTargetClass.getConstructor().newInstance();
        m.invoke(reflectTarget, "待反射方法一号");
        //6、获取一个私有的成员方法
        System.out.println("***************获取私有的show4()方法******************");
        m = reflectTargetClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);
        String result = String.valueOf(m.invoke(reflectTarget, 20));
        System.out.println("返回值 ： " + result);
    }

}
