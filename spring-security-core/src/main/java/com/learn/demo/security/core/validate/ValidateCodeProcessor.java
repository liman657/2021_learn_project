package com.learn.demo.security.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 通用的验证码处理器
 * 由于验证码发送的步骤是通用的三步
 * 1、生成验证码
 * 2、验证码存入session
 * 3、验证码发送
 * 因此针对验证码的处理可以重构成一个统一的处理逻辑（这里用到了模板方法的设计模式）
 */
public interface ValidateCodeProcessor {

    /**
     * 放入session中的验证码前缀
     */
    public String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_VERIFY_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void createVerifyCode(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validateVerifyCode(ServletWebRequest servletWebRequest);

}
