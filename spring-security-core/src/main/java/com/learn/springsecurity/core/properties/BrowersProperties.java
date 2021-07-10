package com.learn.springsecurity.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * autor:liman
 * createtime:2021/7/9
 * comment:
 */
@ConfigurationProperties()
public class BrowersProperties {

    //自定义登录页面
    private String loginPage = "/self-login.html";

    //登录类型
    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
