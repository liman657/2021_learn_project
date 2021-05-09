package com.learn.springsourcedemo.demo.pattern.singleton;

import java.lang.reflect.InvocationTargetException;

public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){

        //第一次检测
        if (instance==null){
            //同步
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance == null){
                    //如果不加volatile，则第二步和第三步会出现对调，会先执行第三步，再执行第二步。如果在最后执行第二步的时候，有线程
                    //进来获取对象，则会获取到一个并没有实质内容的对象
                    //memory = allocate(); //1.分配对象内存空间
                    //instance(memory);    //2.初始化对象
                    //instance = memory;   //3.设置instance指向刚分配的内存地址，此时instance！=null
                    instance = new LazyDoubleCheckSingleton();
                }

            }
        }
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(LazyDoubleCheckSingleton.getInstance());
        System.out.println(LazyDoubleCheckSingleton.getInstance());
    }
}

