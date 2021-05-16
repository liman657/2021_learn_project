package com.learn.demo.security.core.validate;

import java.time.LocalDateTime;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:验证码的公共类
 */
public class ValidateCode {
    private String verifyCode;
    private LocalDateTime expireTime;

    public ValidateCode(String verifyCode, int expireTime) {
        this.verifyCode = verifyCode;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    public ValidateCode(String verifyCode, LocalDateTime expireTime) {
        this.verifyCode = verifyCode;
        this.expireTime = expireTime;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
