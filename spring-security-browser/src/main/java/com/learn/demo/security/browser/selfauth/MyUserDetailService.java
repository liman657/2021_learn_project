package com.learn.demo.security.browser.selfauth;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * autor:liman
 * createtime:2021/5/13
 * comment: 这里可以查询数据库中的用户信息，进行认证
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名:{}",username);

        //这里可以根据查找到的用户信息进行校验，同时可以根据查找到的用户信息判断用户是否冻结
//        return new User(username,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        logger.info("登录密码是:{}",passwordEncoder.encode("123456"));
        return new User(username,passwordEncoder.encode("123456"),AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
