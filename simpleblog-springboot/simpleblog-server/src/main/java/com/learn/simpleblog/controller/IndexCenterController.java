package com.learn.simpleblog.controller;

import com.learn.simpleblog.api.request.BlogRequest;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.ValidatorUtil;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:微博简易版本前端门户网-数据展示与交互
 */
@Slf4j
@RestController
@RequestMapping("web/center")
public class IndexCenterController extends AbstractController{

    @Autowired
    private IBlogService blogService;
    @Autowired
    private IIndexCenterService indexCenterService;

    @Autowired
    private Environment env;

    //首页中心数据列表 - 向下滚动分页
    @RequestMapping(value = "data",method = RequestMethod.GET)
    public BaseResponse data(@RequestParam Map<String,Object> paramMap){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.data(paramMap));
        }catch (Exception e){
            log.info("调用出现异常，异常信息为:{}",e);
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    //我的个人信息
    @RequestMapping(value = "info/my",method = RequestMethod.GET)
    public BaseResponse myInfo(){
        SysUserEntity entity=getUser();
        if (null == entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            //这里是获取用户额外的信息，比如粉丝人数
            response.setData(indexCenterService.getInfoByUId(entity.getUserId()));
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    //发微博
    @PostMapping("blog/send")
    public BaseResponse sendBlog(@RequestBody @Validated BlogRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }

        //敏感词的过滤 - 架构2.0

        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.sendBlog(request,entity.getUserId());

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
