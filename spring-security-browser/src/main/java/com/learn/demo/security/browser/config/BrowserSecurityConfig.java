package com.learn.demo.security.browser.config;

import com.learn.demo.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.learn.demo.security.core.authentication.mobile.SmsCodeFilter;
import com.learn.demo.security.core.authenticationhandler.LearnAuthenticationFailureHandler;
import com.learn.demo.security.core.authenticationhandler.LearnAuthenticationSuccessHandler;
import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * autor:liman
 * createtime:2021/5/13
 * comment: 基本的spring-security的实例
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //登录成功的处理器
    @Autowired
    private LearnAuthenticationSuccessHandler learnAuthenticationSuccessHandler;
    //登录失败的处理器
    @Autowired
    private LearnAuthenticationFailureHandler learnAuthenticationFailureHandler;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;

    //短信验证码登录的配置类
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    //记住我的功能
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);//每次启动的时候，自动建表
        return tokenRepository;
    }


    /**
     * 一共有三种configure方法，这里适用于表单登录
     *
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

        //图形验证码的配置
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setLearnAuthenticationFailureHandler(learnAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        //短信验证码的配置
        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        validateCodeFilter.setLearnAuthenticationFailureHandler(learnAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)//将自定义的短信验证码的过滤器加入到过滤器链上
//                .addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)//将我们自定义的验证码校验器加载username校验器之前
                .formLogin()
                .loginPage("/authentication/require")//配置的登录页面
                .loginProcessingUrl("/authentication/form")//loginProcessingUrl提交这个请求的时候，就会交给UsernamepasswordFilter处理
                .successHandler(learnAuthenticationSuccessHandler)
                .failureHandler(learnAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())//记住我的有效时间
                //http.httpBasic()
                .and()
                .authorizeRequests()//以下是认证的配置
                .antMatchers("/authentication/require",
                        "/code/*", "/demo-signIn.html").permitAll()//登录的页面不需要验证
                .anyRequest()
                .authenticated()//所有请求都需要认证
                .and()
                .csrf().disable()
                .apply(smsCodeAuthenticationSecurityConfig);//放开跨域
    }
}
