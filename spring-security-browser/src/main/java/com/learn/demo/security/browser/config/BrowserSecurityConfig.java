package com.learn.demo.security.browser.config;

import com.learn.demo.security.browser.authenticationhandler.LearnAuthenticationFailureHandler;
import com.learn.demo.security.browser.authenticationhandler.LearnAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * autor:liman
 * createtime:2021/5/13
 * comment: 基本的spring-security的实例
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //登录成功的处理器
    @Autowired
    private LearnAuthenticationSuccessHandler learnAuthenticationSuccessHandler;
    //登录失败的处理器
    @Autowired
    private LearnAuthenticationFailureHandler learnAuthenticationFailureHandler;


    /**
     * 一共有三种configure方法，这里适用于表单登录
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 传统的表单登录配置
         * */
//        http.formLogin()
//                .loginPage("/demo-signIn.html")//配置的登录页面
//                .loginProcessingUrl("/authentication/form")
//                //http.httpBasic()
//                .and()
//                .authorizeRequests()//以下是认证的配置
//                .antMatchers("/demo-signIn.html").permitAll()//登录的页面不需要验证
//                .anyRequest()
//                .authenticated()//所有请求都需要认证
//                .and()
//                .cors().disable();
        http.formLogin()
                .loginPage("/authentication/require")//配置的登录页面
                .loginProcessingUrl("/authentication/form")//loginProcessingUrl提交这个请求的时候，就会交给UsernamepasswordFilter处理
                .successHandler(learnAuthenticationSuccessHandler)
                .failureHandler(learnAuthenticationFailureHandler)
                //http.httpBasic()
                .and()
                .authorizeRequests()//以下是认证的配置
                .antMatchers("/authentication/require","/demo-signIn.html").permitAll()//登录的页面不需要验证
                .anyRequest()
                .authenticated()//所有请求都需要认证
                .and()
                .csrf().disable();//放开跨域
    }
}
