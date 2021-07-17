package com.learn.springsecurity.core.properties;

/**
 * autor:liman
 * createtime:2021/7/14
 * comment:
 */
public class SocialLoginProperties {

    private String processFilterUrl = "/auth";

    private QQSocialLoginProperties qq = new QQSocialLoginProperties();

    public QQSocialLoginProperties getQq() {
        return qq;
    }

    public void setQq(QQSocialLoginProperties qq) {
        this.qq = qq;
    }

    public String getProcessFilterUrl() {
        return processFilterUrl;
    }

    public void setProcessFilterUrl(String processFilterUrl) {
        this.processFilterUrl = processFilterUrl;
    }
}
