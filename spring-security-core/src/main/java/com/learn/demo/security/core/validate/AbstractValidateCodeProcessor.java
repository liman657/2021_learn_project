package com.learn.demo.security.core.validate;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 校验发送验证码的抽象实现
 */
public abstract class AbstractValidateCodeProcessor <C extends ValidateCode> implements ValidateCodeProcessor{

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    /**操作session的工具类*/
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//    @Autowired
//    private ValidateCodeRepository validateCodeRepository;


    /*
     * (non-Javadoc)
     *
     * @see
     * com.imooc.security.core.validate.code.ValidateCodeProcessor#create(org.
     * springframework.web.context.request.ServletWebRequest)
     */
    @Override
    public void createVerifyCode(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * 生成校验码
     * 这里用到了依赖注入的思想，根据不同的generatorName找到对应的生成验证码的具体实现类
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toLowerCase();
//        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        String generatorName = type +"CodeGenerator";
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 保存校验码
     *
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode) {
//        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
//        sessionStrategy.setAttribute(request, code, getValidateCodeType(request));
        sessionStrategy.setAttribute(request,SESSION_KEY_PREFIX+getValidateCodeType(request).toLowerCase(),validateCode);
    }

    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request
     * @return
     */
    private String getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringAfter(request.getRequest().getRequestURI(), "/security/code/");
        return type;
    }

//    @SuppressWarnings("unchecked")
//    @Override
    public void validateVerifyCode(ServletWebRequest request) {
//
//        ValidateCodeType codeType = getValidateCodeType(request);
//
//        C codeInSession = (C) validateCodeRepository.get(request, codeType);
//
//        String codeInRequest;
//        try {
//            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
//                    codeType.getParamNameOnValidate());
//        } catch (ServletRequestBindingException e) {
//            throw new ValidateCodeException("获取验证码的值失败");
//        }
//
//        if (StringUtils.isBlank(codeInRequest)) {
//            throw new ValidateCodeException(codeType + "请填写验证码");
//        }
//
//        if (codeInSession == null) {
//            throw new ValidateCodeException(codeType + "验证码不存在");
//        }
//
//        if (codeInSession.isExpried()) {
//            validateCodeRepository.remove(request, codeType);
//            throw new ValidateCodeException(codeType + "验证码已过期，请重新获取");
//        }
//
//        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
//            throw new ValidateCodeException(codeType + "验证码不正确");
//        }
//
//        validateCodeRepository.remove(request, codeType);
//
    }

}
