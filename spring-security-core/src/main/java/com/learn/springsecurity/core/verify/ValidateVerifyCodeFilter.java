package com.learn.springsecurity.core.verify;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;

/**
 * autor:liman
 * createtime:2021/7/10
 * comment:校验验证码的过滤器
 */
@Slf4j
public class ValidateVerifyCodeFilter extends OncePerRequestFilter {

    //认证失败的异常处理
    private AuthenticationFailureHandler authenticationFailureHandler;

    //拥有获取session
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestUrl = request.getRequestURI();
        String requestMethod = request.getMethod();
        if(StringUtils.equalsIgnoreCase("/security/authentication/form",requestUrl)
                && StringUtils.endsWithIgnoreCase("post",requestMethod)){//如果是表单登录的认证请求
            //开始验证码的校验
            try{
                validateVerifyCode(new ServletWebRequest(request));
            }catch (VerifyCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
                log.error("校验验证码异常");
                return;
            }
        }

        //如果不是登录的校验请求，则直接放过
        filterChain.doFilter(request,response);
    }

    //真正校验验证码的方法
    private void validateVerifyCode(ServletWebRequest request) throws VerifyCodeException{
        //从会话中获取验证码
        ImageVerifyCode codeInSession = (ImageVerifyCode) sessionStrategy.getAttribute(request,VerifyCodeController.SESSION_VERIFY_IMG_CODE);
        String codeInRequest;
        try {
            //从请求中获取图形验证码
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
                    "imgCode");
        } catch (ServletRequestBindingException e) {
            throw new VerifyCodeException("获取验证码的值失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new VerifyCodeException("请填写验证码");
        }

        if (codeInSession == null) {
            throw new VerifyCodeException("验证码不存在");
        }

        if (codeInSession.isExpire()) {
            //验证码过期直接移除
            sessionStrategy.removeAttribute(request, VerifyCodeController.SESSION_VERIFY_IMG_CODE);
            throw new VerifyCodeException("验证码已过期，请重新获取");
        }

        if (!StringUtils.equals(codeInSession.getVerifyCode(), codeInRequest)) {
            throw new VerifyCodeException("验证码不正确");
        }

        sessionStrategy.removeAttribute(request, VerifyCodeController.SESSION_VERIFY_IMG_CODE);
    }


    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
}
