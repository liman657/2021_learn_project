package com.learn.demo.security.core.validate.smscode;

import com.learn.demo.security.core.validate.ValidateCode;
import com.learn.demo.security.core.validate.ValidateCodeGenerator;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
public class SmsCode extends ValidateCode {

    public SmsCode(String verifyCode, int expireTime) {
        super(verifyCode, expireTime);
    }

    public SmsCode(String verifyCode, LocalDateTime expireTime) {
        super(verifyCode, expireTime);
    }
}
