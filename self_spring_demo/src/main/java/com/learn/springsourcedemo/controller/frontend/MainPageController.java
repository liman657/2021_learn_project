package com.learn.springsourcedemo.controller.frontend;

import com.learn.self.springframework.core.annotation.Controller;
import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.dto.MainPageInfoDTO;
import com.learn.springsourcedemo.entity.dto.Result;
import com.learn.springsourcedemo.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * autor:liman
 * createtime:2021/4/23
 * comment:用来处理首页的请求
 */
@Controller
public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    /**
     * 获取主页数据
     * @param req
     * @param resp
     * @return
     */
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        Result<MainPageInfoDTO> mainPageInfo = headLineShopCategoryCombineService.getMainPageInfo();
        return mainPageInfo;
    }

}
