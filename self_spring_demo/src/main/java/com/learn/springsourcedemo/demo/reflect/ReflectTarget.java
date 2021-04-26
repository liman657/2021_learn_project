package com.learn.springsourcedemo.demo.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:测试获取Class对象的三种方式
 */
@Slf4j
public class ReflectTarget {

    /********************构造函数*********************/

    /**
     * 默认的带参数的构造函数
     * @param str
     */
    ReflectTarget(String str){
        log.info("this is default constructor method,parameter:{}",str);
    }

    public ReflectTarget(){
        log.info("default no parameter constructor method");
    }

    /**
     * 共有的构造函数
     * @param name
     */
    public ReflectTarget(char name){
        log.info("这是public的构造函数，参数为:{}",name);
    }

    /**
     * 多个参数的构造方法
     * @param name
     * @param index
     */
    public ReflectTarget(String name, int index){
        log.info("这是多个参数的构造函数,参数为:{},{}",name,index);
    }

    /**
     * 受保护的构造函数
     * @param n
     */
    protected ReflectTarget(boolean n){
        log.info("受保护的构造函数:参数为：{}",n);
    }

    /**
     * 私有的构造函数
     * @param index
     */
    private ReflectTarget(int index){
        log.info("私有的构造函数，参数为:{}",index);
    }

    /********************字段*********************/
    public String name;
    protected int index;
    char type;
    private String targetInfo;

    //***************成员方法***************//
    public void show1(String s){
        System.out.println("调用了公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了默认的，无参的show3()");
    }
    private String show4(int index){
        System.out.println("调用了私有的，并且有返回值的，int参数的show4(): index = " + index);
        return "show4result";
    }

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方式：object.getClass();
        ReflectTarget reflectTarget = new ReflectTarget();
        Class reflectTargetClassMethod01 = reflectTarget.getClass();
        //第二种方式：Class.class
        Class reflectTargetClassMethod02 = ReflectTarget.class;
        //第三种方式：Class.forName();
        Class reflectTargetClassMethod03 = Class.forName("com.learn.springsourcedemo.demo.reflect.ReflectTarget");
        log.info("第一种方式获取的类信息为:{}",reflectTargetClassMethod01.getName());
        log.info("第二种方式获取的类信息为:{}",reflectTargetClassMethod02.getName());
        log.info("第三种方式获取的类信息为:{}",reflectTargetClassMethod03.getName());
        log.info("三种方式取到的Class对象是否是同一个：{}",true);
    }

}
