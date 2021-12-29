package com.learn.simpleblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面模板引擎的渲染(页面跳转由后端负责 - 架构1.0)
 **/
@Controller
public class IndexWebController {

    //首页
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index() throws Exception {
        return "web/index";
    }

    //首页个人中心 - 个人信息、我的微博、我赞过的、我的收藏、好友圈
    @RequestMapping(value = {"web/center"},method = RequestMethod.GET)
    public String indexWebCenter() throws Exception {
        //if (null == ShiroUtil.getUserEntity()){
        //    return "redirect:/login.html";
        //}
        return "web/center";
    }

    @RequestMapping(value = {"web/blogs"},method = RequestMethod.GET)
    public String indexWebblogs() throws Exception {
        //if (null == ShiroUtil.getUserEntity()){
        //    return "redirect:/login.html";
        //}
        return "web/blogs";
    }

    @RequestMapping(value = {"web/praises"},method = RequestMethod.GET)
    public String indexWebpraises() throws Exception {
        //if (null == ShiroUtil.getUserEntity()){
        //    return "redirect:/login.html";
        //}
        return "web/praises";
    }

    @RequestMapping(value = {"web/collects"},method = RequestMethod.GET)
    public String indexWebcollects() throws Exception {
        //if (null == ShiroUtil.getUserEntity()){
        //    return "redirect:/login.html";
        //}
        return "web/collects";
    }

    @RequestMapping(value = {"web/friends"},method = RequestMethod.GET)
    public String indexWebFriends() throws Exception {
        //if (null == ShiroUtil.getUserEntity()){
        //    return "redirect:/login.html";
        //}

        return "web/friends";
    }
}


































