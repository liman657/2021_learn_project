package com.learn.simpleblog.controller;

import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:微博简易版本前端门户网-数据展示与交互
 */
@Slf4j
@RestController
@RequestMapping("web/center")
public class IndexCenterController {

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
}
