package com.learn.springsourcedemo.demo.generic;

/**
 * autor:liman
 * createtime:2021/4/19
 * comment:泛型接口
 */
public interface GenericIFactory<T,N> {


    T nextObject();

    N nextNumber();

}
