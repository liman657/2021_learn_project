package com.learn.self.springframework.inject;

import com.learn.self.springframework.core.container.BeanContainer;
import com.learn.springsourcedemo.controller.frontend.MainPageController;
import com.learn.springsourcedemo.controller.superadmin.HeadLineOperationController;
import com.learn.springsourcedemo.controller.superadmin.ShopCategoryOperationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * autor:liman
 * createtime:2021/5/13
 * comment:
 */
public class DependencyInjectorTest {

    @DisplayName("依赖注入doIoc测试")
    @Test
    public void doIocTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.learn.springsourcedemo");
        Assertions.assertEquals(true,beanContainer.isLoaded());

        ShopCategoryOperationController shopCategoryOperationController = (ShopCategoryOperationController) beanContainer.getBean(ShopCategoryOperationController.class);

        Assertions.assertEquals(true,shopCategoryOperationController instanceof ShopCategoryOperationController);
        Assertions.assertEquals(null,shopCategoryOperationController.getShopCategoryService());

        //开始ioc操作
        new DependencyInjector().doIoc();

        Assertions.assertNotEquals(null,shopCategoryOperationController.getShopCategoryService());


        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertNotEquals(null,mainPageController.getHeadLineShopCategoryCombineService());
    }

}
