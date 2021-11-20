package com.learn.concurrency.finallearn;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:final修饰方法的实例
 */
public class FinalMethodDemo {

    public void drink(){

    }

    //修饰为final 子类无法重写
    public final void eat(){

    }

    public static void sleep(){//静态方法子类也无法重写

    }
}

class SubClass extends FinalMethodDemo{
    //可以复写普通方法
    @Override
    public void drink() {
        super.drink();
    }

//    public void eat(){//提示报错
//
//    }

    public static void sleep(){

    }
}
