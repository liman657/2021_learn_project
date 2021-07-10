package com.learn.springsecurity.browser.config;

import com.learn.springsecurity.browser.authenticationhandler.SelfAuthenticationFailureHandler;
import com.learn.springsecurity.browser.authenticationhandler.SelfAuthenticationSuccessHandler;
import com.learn.springsecurity.core.properties.SecurityProperties;
import com.learn.springsecurity.core.verify.ValidateVerifyCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * autor:liman
 * createtime:2021/7/6
 * comment:
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    //自定义登录成功处理器
    @Autowired
    private SelfAuthenticationSuccessHandler selfAuthenticationSuccessHandler;
    @Autowired
    private SelfAuthenticationFailureHandler selfAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()//采用表单登录
//                .and()
//                .authorizeRequests()//并且要认证请求
//                .anyRequest()//对任意的请求
//                .authenticated();//都需要做认证

        ValidateVerifyCodeFilter validateVerifyCodeFilter = new ValidateVerifyCodeFilter();
        validateVerifyCodeFilter.setAuthenticationFailureHandler(selfAuthenticationFailureHandler);

        http.addFilterBefore(validateVerifyCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()//采用表单登录
                .loginPage("/authentication/require")//指定登录的页面
                .loginProcessingUrl("/authentication/form")//覆盖 UsernamePasswordAuthenticationFilter 中的请求配置，但最终处理这个请求的还是 UsernamePasswordAuthenticationFilter
                .successHandler(selfAuthenticationSuccessHandler)//自定义登录成功处理器
                .failureHandler(selfAuthenticationFailureHandler)
                .and()
                .authorizeRequests()//并且要认证请求
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage(),
                        "/verifycode/img").permitAll()//登录页的请求不需要认证
                .anyRequest()//对任意的请求
                .authenticated()//都需要做认证
                .and().csrf().disable();//关闭csrf
    }
}
