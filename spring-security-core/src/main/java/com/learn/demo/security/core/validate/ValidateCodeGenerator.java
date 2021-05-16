package com.learn.demo.security.core.validate;

import com.learn.demo.security.core.validate.code.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 为了让生成验证码可配置，需要将生成验证码的逻辑抽象成接口
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
