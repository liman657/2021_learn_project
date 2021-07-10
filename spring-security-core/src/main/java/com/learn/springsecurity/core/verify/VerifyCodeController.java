package com.learn.springsecurity.core.verify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * autor:liman
 * createtime:2021/7/10
 * comment:校验码的请求
 */
@RestController
@Slf4j
public class VerifyCodeController {

    public static final String SESSION_VERIFY_IMG_CODE = "SESSION_KEY_IMG_CODE";

    //用于往session中存入验证码
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/verifycode/img")
    public void createImgCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ImageVerifyCode imageVerifyCode = generateImageVerifyCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_VERIFY_IMG_CODE,imageVerifyCode);
        ImageIO.write(imageVerifyCode.getImage(),"JPEG",response.getOutputStream());
    }

    /**
     * 生成图形验证码
     * @param request
     * @return
     */
    private ImageVerifyCode generateImageVerifyCode(HttpServletRequest request){
//        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width",
//                securityProperties.getCode().getImage().getWidth());
//        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height",
//                securityProperties.getCode().getImage().getHeight());
        int width = 67;
        int height = 23;
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
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageVerifyCode(image, sRand, 60);
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

}
