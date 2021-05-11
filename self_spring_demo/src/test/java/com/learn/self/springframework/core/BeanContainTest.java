package com.learn.self.springframework.core;

import com.learn.self.springframework.core.annotation.Controller;
import com.learn.self.springframework.core.container.BeanContainer;
import com.learn.springsourcedemo.controller.DispatcherServlet;
import com.learn.springsourcedemo.controller.frontend.MainPageController;
import com.learn.springsourcedemo.service.solo.IHeadLineService;
import com.learn.springsourcedemo.service.solo.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;

import java.util.Set;

/**
 * autor:liman
 * createtime:2021/5/11
 * comment: BeanContainer的测试类
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//让测试方法按顺序执行
public class BeanContainTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类及其实例到BeanContainer：loadBeanTest")
    @Order(1)
    @Test
    public void loadBeanTest(){
        Assertions.assertEquals(false,beanContainer.isLoaded());
        beanContainer.loadBeans("com.learn.springsourcedemo");
        Assertions.assertEquals(7,beanContainer.size());
        Assertions.assertEquals(true,beanContainer.isLoaded());
    }

    @DisplayName("根据类获取其实例：getBeanTest")
    @Order(2)
    @Test
    public void getBeanTest(){
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        Assertions.assertEquals(null,dispatcherServlet);
    }

    @DisplayName("根据注解获取对应的实例:getClassesByAnnotationTest")
    @Order(3)
    @Test
    public void getClassesByAnnotationTest(){
        Assertions.assertEquals(true,beanContainer.isLoaded());
        Assertions.assertEquals(3,beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @DisplayName("根据接口获取实现类：getClassesBySuperTest")
    @Order(4)
    @Test
    public void getClassesBySuperTest(){
        Assertions.assertEquals(true,beanContainer.isLoaded());
        Assertions.assertEquals(true,beanContainer.getClassesBySuper(IHeadLineService.class).contains(HeadLineServiceImpl.class));
    }
}
