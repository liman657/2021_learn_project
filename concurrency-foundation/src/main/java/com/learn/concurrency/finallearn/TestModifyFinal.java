package com.learn.concurrency.finallearn;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:测试修改Final修饰的类
 */
@Slf4j
public class TestModifyFinal {

    public static void main(String[] args) {
        FinalPersonDemo personDemo = new FinalPersonDemo();
//        personDemo.age=10;

        final OridnaryPersonDemo oridnaryPersonDemo = new OridnaryPersonDemo();
        //oridnaryPersonDemo = new OridnaryPersonDemo();会报错
        //final 修饰的对象，只是其指向的内存地址不能变，对象的内部属性值还是可以被修改的。
        oridnaryPersonDemo.age=10;
        oridnaryPersonDemo.name="other one";
    }

}
