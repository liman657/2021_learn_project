package com.learn.demo.security.core.validate.smscode;

import com.learn.demo.security.core.properties.SecurityConstants;
import com.learn.demo.security.core.validate.AbstractValidateCodeProcessor;
import com.learn.demo.security.core.validate.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.sendCode(mobile, validateCode.getVerifyCode());
    }

}
