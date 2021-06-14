package com.learn.springread.postprocessor;

import com.learn.springread.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的BeanDefinitionRegistryPostProcessor
 * 通过这样的方式，可以自己注册相关内容
 * 可以通过这个机制，在定义的BeanDefinitionRegistryPostProcessor里面，自己去搜索第三方的class包，然后将其注册进入spring容器中
 * 这样就可以在spring中用这些内容，mybatis就是这么玩的，也正因为这个机制，spring可以与其他框架无缝整合
 */
@Configuration//需要这个类被spring感知到 这里变成@Bean也可以
public class CustomizedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

		//在这里，我们可以额外手动增加需要注册的bean

		Class<?> clazz = User.class;
		//创建BeanDefinition实例
		BeanDefinitionBuilder builder =BeanDefinitionBuilder.genericBeanDefinition(clazz);
		//通过builder 获取GenericBeanDefinition实例
		GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
		//通过参数传递进来的 registry 注册bean
		registry.registerBeanDefinition("user5", definition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
