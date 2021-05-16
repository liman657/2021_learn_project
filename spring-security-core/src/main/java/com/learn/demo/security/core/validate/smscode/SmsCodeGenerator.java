package com.learn.demo.security.core.validate.smscode;

import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.ValidateCode;
import com.learn.demo.security.core.validate.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 短信验证码的生成器
 */
@Component
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        int length = securityProperties.getCode().getSms().getLength();
        int defaultExpireInt = securityProperties.getCode().getSms().getExpireIn();

        String verifyCode = RandomStringUtils.randomNumeric(length);
        return new SmsCode(verifyCode,defaultExpireInt);
    }
}
