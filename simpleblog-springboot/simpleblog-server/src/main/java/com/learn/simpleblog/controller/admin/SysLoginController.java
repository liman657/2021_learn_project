package com.learn.simpleblog.controller.admin;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.common.collect.Maps;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.controller.AbstractController;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.shiro.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 登录controller
 * @Author:debug (SteadyJack)
 **/
@Controller
public class SysLoginController extends AbstractController {

    @Autowired
    private Producer producer;

    @Autowired
    private Environment env;


    /**
     * 生成验证码方式二
     * @param response
     * @throws Exception
     */
    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtil.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);

        System.out.println("验证码："+text);
    }


    /**
     * 登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @RequestMapping(value = "/sys/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse login(String username, String password, String captcha){
        log.info("用户名：{} 密码：{} 验证码:{}",username,password,captcha);

        Map<String,Object> resMap= Maps.newHashMap();
        int userType=0;

        //校验验证码
        /*String kaptcha=ShiroUtil.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!kaptcha.equals(captcha)){
            return new BaseResponse(StatusCode.InvalidCode);
        }*/

        try {
            //提交登录
            Subject subject= SecurityUtils.getSubject();
            if (!subject.isAuthenticated()){
                UsernamePasswordToken token=new UsernamePasswordToken(username,password);
                subject.login(token);
            }


            SysUserEntity entity=getUser();
            resMap.put("userType",userType);
            if (entity!=null){
                resMap.put("userType",entity.getType());
                entity.setPassword(null);
                entity.setSalt(null);
                if (StringUtils.isNotBlank(entity.getImgUrl()) && entity.getImgUrl().startsWith("/statics")){
                    entity.setImgUrl(env.getProperty("common.user.img.root.url")+entity.getImgUrl());
                }else{
                    entity.setImgUrl(env.getProperty("common.file.access.root.url")+entity.getImgUrl());
                }
                resMap.put("userInfo",entity);
            }
        }catch (UnknownAccountException e) {
            return new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return new BaseResponse(StatusCode.AccountPasswordNotMatch);
        }catch (LockedAccountException e) {
            return new BaseResponse(StatusCode.AccountHasBeenLocked);
        }catch (AuthenticationException e) {
            return new BaseResponse(StatusCode.AccountValidateFail);
        }

        BaseResponse response=new BaseResponse(StatusCode.Success);
        response.setData(resMap);
        return response;
    }


    //退出登录
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        //销毁当前的shiro的用户session
        ShiroUtil.logout();
        return "redirect:login.html";
    }

    /*@Autowired
    private WebSocketIndexMsgServer webSocketIndexMsgServer;

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        webSocketIndexMsgServer.onCloseUser(ShiroUtil.getUserId().toString());
        ShiroUtil.logout();
        return "redirect:login.html";
    }*/

}




















