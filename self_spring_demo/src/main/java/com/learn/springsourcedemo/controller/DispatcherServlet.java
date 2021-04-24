package com.learn.springsourcedemo.controller;

import com.learn.springsourcedemo.controller.frontend.MainPageController;
import com.learn.springsourcedemo.controller.superadmin.HeadLineOperationController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:派发类
 * 1、拦截所有的请求
 * 2、解析所有请求
 * 3、派发给指定的controller进行处理
 */
@WebServlet("/")//这里就是拦截所有请求
@Slf4j
public class DispatcherServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解析所有请求
        String requestPath = req.getServletPath();
        String method = req.getMethod();
        log.info("开始处理的请求路径:{},请求方法:{}",requestPath,method);

        if (req.getServletPath() == "/frontend/getmainpageinfo" && req.getMethod() == "GET"){
            new MainPageController().getMainPageInfo(req, resp);
        } else if(req.getServletPath() == "/superadmin/addheadline" && req.getMethod() == "POST"){
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }
}
