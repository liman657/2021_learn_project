package com.learn.demo.security.core.validate;

import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.smscode.DefaultSmsSender;
import com.learn.demo.security.core.validate.smscode.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name="imageCodeGenerator")//利用spring的条件注入，如果容器中已经存在imageCodeGenerator，则不再使用这里的bean
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsSender.class)//利用spring的条件注入，如果容器中已经存在imageCodeGenerator，则不再使用这里的bean
    public SmsSender smsSender(){
        SmsSender defaultSmsSender = new DefaultSmsSender();
//        imageCodeGenerator.setSecurityProperties(securityProperties);
        return defaultSmsSender;
    }

}
