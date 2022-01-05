package com.learn.simpleblog.controller;

import com.learn.simpleblog.api.request.UserRequest;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.api.utils.ValidatorUtil;
import com.learn.simpleblog.service.web.IIndexUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * autor:liman
 * createtime:2022/1/4
 * comment:用户注册相关
 */
@Slf4j
@RestController
@RequestMapping("web/user")
public class UserController extends AbstractController{

    @Autowired
    private IIndexUserService indexUserService;

    /**
     * 普通微博用户的注册
     * @param userRequest
     * @param result
     * @return
     */
    //用户注册
    @PostMapping("register")
    public BaseResponse register(@Validated @RequestBody UserRequest userRequest, BindingResult result){
        if (StringUtils.isBlank(userRequest.getUsername())){
            return new BaseResponse(StatusCode.UserNameCanNotBlank);
        }
        String checkRes= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidCode.getCode(),checkRes);
        }
        //用户名 字段规范化 - 正则判断(字母、数字所组成)
        if (!userRequest.getUsername().matches(Constant.RegexRoute)){
            return new BaseResponse(StatusCode.UserNameRegisterInvalid);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            userRequest.setType(0);
            userRequest.setStatus(1);
            log.info("前端用户注册，提交的信息：{}",userRequest);
            indexUserService.registerUser(userRequest);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 头像上传
     * @param request
     * @return
     */
    //上传用户头像
    @RequestMapping(value = "image/upload",method = RequestMethod.POST)
    public BaseResponse uploadMyImage(MultipartHttpServletRequest request){
        if (null==getUser()){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexUserService.uploadImg(request,getUserId()));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

}
