package com.learn.springsourcedemo.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * autor:liman
 * createtime:2021/4/28
 * comment: 这个注解可以存在于方法和类上
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfoAnnotation {
    //课程名称
    public String courseName();
    //课程标签
    public String courseTag();
    //课程简介
    public String courseProfile();
    //课程序号
    public int courseIndex() default 303;

}
