package com.learn.springsourcedemo.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * autor:liman
 * createtime:2021/4/28
 * comment: 标注于属性上的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {
    public String name();

    public int age() default 19;

    public String gender() default "男";

    public String[] language();
}
