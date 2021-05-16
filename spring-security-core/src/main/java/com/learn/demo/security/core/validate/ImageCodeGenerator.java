package com.learn.demo.security.core.validate;

import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.code.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        int defaultWidth = securityProperties.getCode().getImage().getWidth();
        int defaultHeight = securityProperties.getCode().getImage().getHeight();
        int defaultLength = securityProperties.getCode().getImage().getLength();
        int defaultExpireTime = securityProperties.getCode().getImage().getExpireTime();
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", defaultWidth);
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", defaultHeight);


//        int width = 67;//图片的宽
//        int height = 23;//图片的高
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String sRand = "";
        for (int i = 0; i < defaultLength; i++) {//验证码的位数
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageCode(image, sRand, defaultExpireTime);//验证码有效期
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
