package com.learn.demo.security.core.validate;

import com.learn.demo.security.core.validate.code.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 发送验证码的重构版本——01
 */
@RestController
public class ValidateCodeControllerUpdate {

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    /**
     * 验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response,@PathVariable String type) throws IOException {
        validateCodeGenerators.get(type+"CodeGenerator").generate(new ServletWebRequest(request,response));
    }

}
