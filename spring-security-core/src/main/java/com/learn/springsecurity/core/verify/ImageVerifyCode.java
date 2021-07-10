package com.learn.springsecurity.core.verify;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * autor:liman
 * createtime:2021/7/10
 * comment: 图形验证码
 */
@Data
public class ImageVerifyCode {

    private BufferedImage image;

    private String verifyCode;

    private LocalDateTime expireTime;

    public ImageVerifyCode(BufferedImage image, String verifyCode, int expireSecond) {
        this.image = image;
        this.verifyCode = verifyCode;
        this.expireTime = LocalDateTime.now().plusSeconds(expireSecond);
    }

    public ImageVerifyCode(BufferedImage image, String verifyCode, LocalDateTime expireTime) {
        this.image = image;
        this.verifyCode = verifyCode;
        this.expireTime = expireTime;
    }
    public boolean isExpire(){
        return LocalDateTime.now().isAfter(expireTime);
    }
}
