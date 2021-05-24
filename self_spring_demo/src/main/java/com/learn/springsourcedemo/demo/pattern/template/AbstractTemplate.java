package com.learn.springsourcedemo.demo.pattern.template;

public abstract class AbstractTemplate {
    //模板方法
    public void templateMethod(){
        concreteMethod();
        hookMethod();
        abstractMethod();
    }
    //具体方法
    public void concreteMethod(){
        System.out.println("模板里自带的实现方法，万年不变");
    }
    //钩子方法，子类可以依据情况实现的方法
    protected void hookMethod(){}
    //抽象方法，必须让子类实现的方法
    public abstract void abstractMethod();
}

