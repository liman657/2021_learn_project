package com.learn.self.springframework.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/5/7
 * comment:
 */
public class ClassUtilTest {

    @DisplayName("提取目标类方法:extractPackageClassTest")
    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classes = ClassUtil.extractPackageClass("com.learn.springsourcedemo.entity");
        System.out.println(classes.size());
    }

    @Test
    public void test(){
        BigDecimal value1 = new BigDecimal(1);
        BigDecimal value2 = new BigDecimal(2);
        BigDecimal value3 = value1.add(value2);
        System.out.println("value1+"+value1+"value2:"+value2+"value3:"+value3);
    }

}
