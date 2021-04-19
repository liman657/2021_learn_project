package com.learn.springsourcedemo.demo.generic;

/**
 * autor:liman
 * createtime:2021/4/19
 * comment:实现泛型接口的泛型类，如果实现泛型接口
 * 实现泛型接口既可以是普通类，也可以是泛型类
 */
public class GenericIFactoryImpl<T,N> implements GenericIFactory<T,N> {

    @Override
    public T nextObject() {
        return null;
    }

    @Override
    public N nextNumber() {
        return null;
    }
}
