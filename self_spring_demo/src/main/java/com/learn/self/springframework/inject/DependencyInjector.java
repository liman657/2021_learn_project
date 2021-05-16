package com.learn.self.springframework.inject;

import com.learn.self.springframework.core.container.BeanContainer;
import com.learn.self.springframework.inject.annotation.Autowired;
import com.learn.self.springframework.util.ClassUtil;
import com.learn.self.springframework.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/5/12
 * comment: 完成容器中相关依赖注入的功能
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    /**
     * 构造的时候初始化bean容器
     */
    public DependencyInjector(){
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC操作
     */
    public void doIoc(){
        if(ValidationUtil.isEmpty(beanContainer.getClasses())){
            log.warn("empty class set in bean container");
        }
        //1.遍历Bean容器中所有的Class对象
        for(Class<?> clazz : beanContainer.getClasses()){
            //2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if(ValidationUtil.isEmpty(fields)){//不需要注入，则直接进入下一个循环
                continue;
            }

            for(Field field:fields){
                //3.找出被Autowired标记的成员变量
                if(field.isAnnotationPresent(Autowired.class)){
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();
                    //4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue=getFieldInstance(fieldClass,autowiredValue);
                    if(fieldValue == null){
                        throw new RuntimeException("unable to inject relevant type，target fieldClass is:" + fieldClass.getName() + " autowiredValue is : " + autowiredValue);
                    } else {
                        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean =  beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }

        //3.找出被Autowired标记的成员变量
        //4.获取这些成员变量的类型
        //5.获取这些成员变量的类型在容器里对应的实例
        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
    }

    /**
     * 根据 Class 在 beanContainer 里获取其实例或者实现类
     * @param fieldClass
     * @param autowiredValue
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if(null!=fieldValue){
            return fieldValue;
        }else{
            Class<?> implementClass = getImplementedClass(fieldClass,autowiredValue);
            if(null!=implementClass){
                return beanContainer.getBean(implementClass);
            }else{
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     */
    private Class<?> getImplementedClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if(!ValidationUtil.isEmpty(classSet)){
            if(ValidationUtil.isEmpty(autowiredValue)){
                if(classSet.size() == 1){
                    return classSet.iterator().next();
                } else {
                    //如果多于两个实现类且用户未指定其中一个实现类，则抛出异常
                    throw new RuntimeException("multiple implemented classes for " + fieldClass.getName() + " please set @Autowired's value to pick one");
                }
            } else {//如果autowired设置了指定的bean的值
                for(Class<?> clazz : classSet){
                    if(autowiredValue.equals(clazz.getSimpleName())){
                        return clazz;
                    }
                }
            }
        }
        return null;
    }

}
