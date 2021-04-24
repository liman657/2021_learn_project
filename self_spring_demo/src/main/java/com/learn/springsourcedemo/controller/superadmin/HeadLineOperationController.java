package com.learn.springsourcedemo.controller.superadmin;

import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.dto.Result;
import com.learn.springsourcedemo.service.solo.IHeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:对头条信息进行操作的controller
 */
public class HeadLineOperationController {
    private IHeadLineService headLineService;
    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.addHeadLine(new HeadLine());
    };
    public Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.removeHeadLine(1);
    }
    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }
    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }
    public Result<List<HeadLine>>queryHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLine(null, 1, 100);
    }
}
