package com.learn.demo.security.core.validate;

import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.code.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
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
 * createtime:2021/5/16
 * comment: 验证码controller
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_VERIFY_CODE_KEY = "SESSION_IMAGE_KEY_CODE";

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private SecurityProperties securityProperties;
    
    private SessionStrategy sessionStrategy =new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request) );

        //将验证码存入session
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_VERIFY_CODE_KEY,imageCode);

        ImageIO.write(imageCode.getBufferedImage(),"JPEG",response.getOutputStream());
    }


}
