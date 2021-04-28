package com.learn.springsourcedemo.demo.annotation;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/28
 * comment: 测试注解的实体类
 */
@CourseInfoAnnotation(courseName = "类注解上的课程", courseTag = "玩",
        courseProfile = "为了学习注解"
)
public class TestAnnoCourse {

    @PersonInfoAnnotation(name = "coder", language = {"Java","C++","Go","Python","PHP","JS"})
    private String author;

    @CourseInfoAnnotation(courseName = "方法注解上的课程",
            courseTag = "方法play",
            courseProfile = "方法注解上的课程profile",
            courseIndex = 155)
    public void getCourseInfo() {

    }

}
