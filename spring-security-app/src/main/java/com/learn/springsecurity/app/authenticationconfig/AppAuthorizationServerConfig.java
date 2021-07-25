package com.learn.springsecurity.app.authenticationconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * autor:liman
 * createtime:2021/7/22
 * comment: app的认证服务器配置类
 *
 * http://www.ictgu.cn/oauth/authorize?response_type=code&client_id=selfclientid&redirect_uri=http://example.com&scope=all
 */
@Configuration
@EnableAuthorizationServer
public class AppAuthorizationServerConfig {
}
