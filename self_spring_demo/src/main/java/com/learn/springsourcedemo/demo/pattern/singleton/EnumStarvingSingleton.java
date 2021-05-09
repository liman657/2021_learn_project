package com.learn.springsourcedemo.demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举的单例实例
 */
public class EnumStarvingSingleton {
    private EnumStarvingSingleton(){}
    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder(){
            instance = new EnumStarvingSingleton();
        }
    }

}
