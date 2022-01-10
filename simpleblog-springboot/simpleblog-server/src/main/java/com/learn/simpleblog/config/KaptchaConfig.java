package com.learn.simpleblog.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码的自定义注入配置
 * @Author:liman
 * @Date: 2019/7/30 17:28
 **/
@Configuration
public class KaptchaConfig {

//    @Bean
//    public DefaultKaptcha producer() {
//        Properties properties = new Properties();
//
//        //是否有图片边框
//        properties.setProperty("kaptcha.border", "no");
//        //边框颜色
//        properties.setProperty("kaptcha.border.color", "105,179,90");
//        //字体颜色
//        properties.setProperty("kaptcha.textproducer.font.color", "blue");
//        //图片宽
//        properties.setProperty("kaptcha.image.width", "135");
//        //图片高
//        properties.setProperty("kaptcha.image.height", "30");
//        //字体大小
//        properties.setProperty("kaptcha.textproducer.font.size", "30");
//        //session key
//        properties.setProperty("kaptcha.session.key", "kaptchaCode");
//        //验证码长度
//        properties.setProperty("kaptcha.textproducer.char.length", "5");
//        //使用那些字符生成验证码
//        properties.setProperty("kaptcha.textproducer.char.string", "ACDEFHKPRSTWX345679");
//        //使用哪些字体
//        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier,cmr10,宋体,楷体,微软雅黑");
//        //干扰线颜色
//        properties.setProperty("kaptcha.noise.color", "black");
//        //图片样式阴影
//        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
//
//        Config config = new Config(properties);
//        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
//        defaultKaptcha.setConfig(config);
//        return defaultKaptcha;
//    }


    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "5");
        properties.put("kaptcha.textproducer.font.names", "Arial,Courier,cmr10,宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}




























