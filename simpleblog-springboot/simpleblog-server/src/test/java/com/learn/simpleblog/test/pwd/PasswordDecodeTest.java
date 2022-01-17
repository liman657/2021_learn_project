package com.learn.simpleblog.test.pwd;

import cn.hutool.core.util.RandomUtil;
import com.learn.simpleblog.shiro.ShiroUtil;

/**
 * autor:liman
 * createtime:2022-01-17
 * comment:解密
 */
public class PasswordDecodeTest {

    public static void main(String[] args) {
        //加密密码串
        //String salt= RandomStringUtils.randomAlphanumeric(20);

        String salt= "UsyQ2c0TDvycqqD03HQP";
        String originPwd = "123456";
        String password= ShiroUtil.sha256(originPwd,salt);
        System.out.println(password);
    }

}
