package com.learn.springsourcedemo.demo.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * autor:liman
 * createtime:2021/4/28
 * comment:
 */
@Slf4j
public class AnnotatioinClassDemo {

    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.learn.springsourcedemo.demo.annotation.TestAnnoCourse");
        //这里获取的是class对象的注解，而不是里面的方法和成员变量的注解
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation:annotations){
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            log.info("类上的注解信息为");
            log.info("{},{},{},{},{}",courseInfoAnnotation.courseName(),
                    courseInfoAnnotation.courseProfile(),
                    courseInfoAnnotation.courseTag(),
                    courseInfoAnnotation.courseIndex());
        }
    }

    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.learn.springsourcedemo.demo.annotation.TestAnnoCourse");
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            boolean hasAnnotation = f.isAnnotationPresent(PersonInfoAnnotation.class);
            if(hasAnnotation){
                PersonInfoAnnotation personInfoAnnotation = f.getAnnotation(PersonInfoAnnotation.class);
                log.info("属性上的注解信息");
                log.info("{},{},{},{},{}",personInfoAnnotation.name(),
                        personInfoAnnotation.age(),
                        personInfoAnnotation.gender(),
                        personInfoAnnotation.language());
            }

        }
    }

    /**
     * 解析方法上的注解
     */
    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.learn.springsourcedemo.demo.annotation.TestAnnoCourse");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(CourseInfoAnnotation.class);
            if(hasAnnotation){
                CourseInfoAnnotation courseInfoAnnotation = method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println("课程名：" + courseInfoAnnotation.courseName() + "\n" +
                        "课程标签：" + courseInfoAnnotation.courseTag() + "\n" +
                        "课程简介：" + courseInfoAnnotation.courseProfile() + "\n"+
                        "课程序号：" + courseInfoAnnotation .courseIndex() + "\n");
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();

        parseFieldAnnotation();

        parseMethodAnnotation();
    }

}
