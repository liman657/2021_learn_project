package com.learn.self.springframework.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
