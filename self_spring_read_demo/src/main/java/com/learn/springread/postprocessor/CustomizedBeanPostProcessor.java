package com.learn.springread.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的BeanPostProcessor，可以在Bean创建之前和之后，针对Bean做一些操作
 * 可以通过这个实现AOP
 */
@Configuration
public class CustomizedBeanPostProcessor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
		System.out.println(beanName + "调用了 postProcessBeforeInitialization() ");
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		System.out.println(beanName + "调用了 postProcessAfterInitialization() ");
		return bean;
	}
}
