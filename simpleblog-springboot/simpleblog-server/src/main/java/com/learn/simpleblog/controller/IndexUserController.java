package com.learn.simpleblog.controller;

import com.learn.simpleblog.api.request.IdRequest;
import com.learn.simpleblog.api.request.UserRequest;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.api.utils.ValidatorUtil;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.service.web.IIndexUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

///**
// * 前端门户网-用户controller
// * @Author:liman
// * @Link: weixin-> debug0868 qq-> 1948831260
// **/
//@RestController
//@RequestMapping("web/user")
//public class IndexUserController extends AbstractController{
//
//    private static final Logger log= LoggerFactory.getLogger(IndexUserController.class);
//
//    @Autowired
//    private IIndexUserService indexUserService;
//

//    //用户注册
//    @PostMapping("register")
//    public BaseResponse register(@Validated @RequestBody UserRequest userRequest, BindingResult result){
//        if (StringUtils.isBlank(userRequest.getUsername())){
//            return new BaseResponse(StatusCode.UserNameCanNotBlank);
//        }
//        String checkRes=ValidatorUtil.checkResult(result);
//        if (StringUtils.isNotBlank(checkRes)){
//            return new BaseResponse(StatusCode.InvalidCode.getCode(),checkRes);
//        }
//        //用户名 字段规范化 - 正则判断(字母、数字所组成)
//        if (!userRequest.getUsername().matches(Constant.RegexRoute)){
//            return new BaseResponse(StatusCode.UserNameRegisterInvalid);
//        }
//        BaseResponse response=new BaseResponse(StatusCode.Success);
//        try {
//            userRequest.setType(0);
//            userRequest.setStatus(1);
//
//            log.info("前端用户注册，提交的信息：{}",userRequest);
//            indexUserService.registerUser(userRequest);
//        }catch (Exception e){
//            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
//        }
//        return response;
//    }

//    //上传用户头像
//    @RequestMapping(value = "image/upload",method = RequestMethod.POST)
//    public BaseResponse uploadMyImage(MultipartHttpServletRequest request){
//        if (null==getUser()){
//            return new BaseResponse(StatusCode.UserNotLogin);
//        }
//        BaseResponse response=new BaseResponse(StatusCode.Success);
//        try {
//            response.setData(indexUserService.uploadImg(request,getUserId()));
//
//        }catch (Exception e){
//            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
//        }
//        return response;
//    }

//    //修改个人信息
//    @PostMapping(value = "info/update")
//    public BaseResponse updateInfo(@RequestBody @Validated UserRequest userRequest, BindingResult result){
//        SysUserEntity entity=getUser();
//        if (null==entity){
//            return new BaseResponse(StatusCode.UserNotLogin);
//        }
//        BaseResponse response=new BaseResponse(StatusCode.Success);
//        try {
//            userRequest.setUserId(entity.getUserId());
//            indexUserService.updateUser(userRequest);
//
//        }catch (Exception e){
//            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
//        }
//        return response;
//    }
//
//
//    //用户消息中心
//    @RequestMapping(value = "msg",method = RequestMethod.GET)
//    public BaseResponse register(){
//        SysUserEntity entity=getUser();
//        if (null==entity){
//            return new BaseResponse(StatusCode.UserNotLogin);
//        }
//        BaseResponse response=new BaseResponse(StatusCode.Success);
//        try {
//            response.setData(indexUserService.getUserMsg(entity.getUserId().intValue()));
//
//        }catch (Exception e){
//            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
//        }
//        return response;
//    }
//
//    //读消息
//    @PostMapping("msg/read")
//    public BaseResponse readMsg(@RequestBody @Validated IdRequest request, BindingResult result){
//        SysUserEntity entity=getUser();
//        if (entity==null){
//            return new BaseResponse(StatusCode.UserNotLogin);
//        }
//        String checkRes= ValidatorUtil.checkResult(result);
//        if (StringUtils.isNotBlank(checkRes)){
//            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
//        }
//        BaseResponse response=new BaseResponse(StatusCode.Success);
//        try {
//            response.setData(indexUserService.readMsg(request,entity.getUserId()));
//
//        }catch (Exception e){
//            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
//        }
//        return response;
//    }
//
//}






































































