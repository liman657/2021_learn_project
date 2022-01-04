package com.learn.simpleblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * autor:liman
 * createtime:2021-12-28
 * comment:css等文件转发配置类
 */
@Configuration
public class MvcWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/statics/css/**.css").addResourceLocations("classpath:/statics/css/");
        //registry.addResourceHandler("/statics/js/**.js").addResourceLocations("classpath:/statics/js/");
        //registry.addResourceHandler("/statics/**/**.*").addResourceLocations("classpath:/statics/**/");
//        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("/**.html").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/statics/images/");
    }
}
