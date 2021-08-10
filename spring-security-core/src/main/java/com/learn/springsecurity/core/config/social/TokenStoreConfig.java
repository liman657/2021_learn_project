package com.learn.springsecurity.core.config.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * autor:liman
 * createtime:2021/8/9
 * comment: token存储的配置
 */
@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
//    @Autowired
//    private DataSource dataSource;

    @Bean
    public TokenStore redisTokenStore(){
//        new JdbcTokenStore(dataSource);
        return new RedisTokenStore(redisConnectionFactory);

    }

}
