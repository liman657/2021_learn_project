package com.learn.demo.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
public class ImageCode {

    private BufferedImage bufferedImage;
    private String verifyCode;
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage bufferedImage, String verifyCode, int expireTime) {
        this.bufferedImage = bufferedImage;
        this.verifyCode = verifyCode;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }


    public ImageCode(BufferedImage bufferedImage, String verifyCode, LocalDateTime expireTime) {
        this.bufferedImage = bufferedImage;
        this.verifyCode = verifyCode;
        this.expireTime = expireTime;
    }



    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
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
