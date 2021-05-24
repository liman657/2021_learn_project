package com.learn.springread;

import com.imooc.controller.WelcomeController;
import com.imooc.entity.User;
import com.imooc.entity.factory.UserFactoryBean;
import com.imooc.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ComponentScan("com.imooc")
public class Entrance {
	public static void main1(String[] args) {
		System.out.println("Hello World!");
		String xmlPath = "//Users/baidu/imooc/springframework/spring-framework-5.2.0.RELEASE/springdemo/src/main/resources/spring/spring-config.xml";
		 ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
		welcomeService.sayHello("强大的spring框架");

		//得到无参构造函数创建的对象:
		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");
//得到静态工厂创建的对象：
		User user2a = (User) applicationContext.getBean("user2");
		User user2c = (User) applicationContext.getBean("user2");
//得到实例工厂创建的对象：
		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");

		//得到beanFactory创建的对象：
		UserFactoryBean userFactoryBean4a = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
		User user4b = (User) applicationContext.getBean("userFactoryBean");

		System.out.println("无参构造函数创建的对象:" + user1a);
		System.out.println("无参构造函数创建的对象:" + user1b);
		System.out.println("静态工厂创建的对象：" + user2a);
		System.out.println("静态工厂创建的对象：" + user2c);
		System.out.println("实例工厂创建的对象：" + user3a);
		System.out.println("实例工厂创建的对象：" + user3b);
		System.out.println("factorybean对象：" + userFactoryBean4a);
		System.out.println("factorybean创建的对象：" + user4b);

	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames){
			System.out.println(beanDefinitionName);
		}
		WelcomeController welcomeController = (WelcomeController) applicationContext.getBean("welcomeController");
		welcomeController.handleRequest();
		User user5 = (User)applicationContext.getBean("user5");
		System.out.println("CustomizedBeanDefinitionRegistryPostProcessor创建的对象：" + user5);
	}
}
