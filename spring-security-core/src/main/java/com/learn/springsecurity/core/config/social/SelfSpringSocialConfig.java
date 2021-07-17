package com.learn.springsecurity.core.config.social;

import org.springframework.context.annotation.Configuration;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * autor:liman
 * createtime:2021/7/15
 * comment:自定义的springsocial配置类
 */
public class SelfSpringSocialConfig extends SpringSocialConfigurer {

    private String processFilterUrl;

    public SelfSpringSocialConfig(String processFilterUrl) {
        this.processFilterUrl = processFilterUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter socialAuthenticationFilter = (SocialAuthenticationFilter) super.postProcess(object);
        socialAuthenticationFilter.setFilterProcessesUrl(processFilterUrl);
        return (T) socialAuthenticationFilter;
    }
}
