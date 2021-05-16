package com.learn.demo.security.core.authentication.mobile;

import com.learn.demo.security.core.authenticationhandler.LearnAuthenticationFailureHandler;
import com.learn.demo.security.core.properties.SecurityProperties;
import com.learn.demo.security.core.validate.ValidateCodeException;
import com.learn.demo.security.core.validate.code.ImageCode;
import com.learn.demo.security.core.validate.smscode.SmsCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 自定义的短信验证码过滤器
 * 实现InitializingBean接口，用于自定义需要验证码的url，为了在其他参数都组装完成之后，初始化我们的urls
 */
public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private String SESSION_VERIFY_CODE_KEY = "SESSION_VERIFY_CODE_V_0.1";

    private LearnAuthenticationFailureHandler learnAuthenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private SecurityProperties securityProperties;

    //spring的工具类，用于判断url是否匹配
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    //用于存放需要用到验证码的url
    private Set<String> urls = new HashSet<>();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        String configUrl = securityProperties.getCode().getSms().getUrl();
        String[] toVerifyCodeUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(configUrl, ",");
        if(null== toVerifyCodeUrls) return;
        for(String str:toVerifyCodeUrls){
            urls.add(str);
        }
        urls.add("/security/authentication/mobile");//登录的请求也需要做验证码的认证
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean isMatch = false;
        String requestUri = httpServletRequest.getRequestURI();
        for(String url:urls){
            if(antPathMatcher.match(url,requestUri)){
                isMatch = true;
            }
        }

//        if(StringUtils.equals("/security/authentication/form",httpServletRequest.getRequestURI())
//                && StringUtils.endsWithIgnoreCase(httpServletRequest.getMethod(),"post")){
        if(isMatch){

            try{
                //这里是校验验证码
                validateCode(new ServletWebRequest(httpServletRequest));
            }catch (ValidateCodeException e){
                //这里处理异常，然后返回错误信息
                learnAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                return;
            }

        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    /**
     * 检验验证码
     * @param servletWebRequest
     */
    private void validateCode(ServletWebRequest servletWebRequest) throws ValidateCodeException, ServletRequestBindingException {

        //从session中获取验证码
        SmsCode codeInSession = (SmsCode) sessionStrategy.getAttribute(servletWebRequest, SESSION_VERIFY_CODE_KEY);

        //从请求中获取验证码
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "smsCode");



        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("请填写验证码");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpried()) {//过期之后，删除验证码
            sessionStrategy.removeAttribute(servletWebRequest, SESSION_VERIFY_CODE_KEY);
            throw new ValidateCodeException("验证码已过期，请重新获取");
        }

        if (!StringUtils.equals(codeInSession.getVerifyCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不正确");
        }

        //验证完成之后，删除验证码
        sessionStrategy.removeAttribute(servletWebRequest, SESSION_VERIFY_CODE_KEY);

    }

    public LearnAuthenticationFailureHandler getLearnAuthenticationFailureHandler() {
        return learnAuthenticationFailureHandler;
    }

    public void setLearnAuthenticationFailureHandler(LearnAuthenticationFailureHandler learnAuthenticationFailureHandler) {
        this.learnAuthenticationFailureHandler = learnAuthenticationFailureHandler;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
