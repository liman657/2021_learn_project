package com.learn.simpleblog.controller.admin;

import com.learn.simpleblog.module.domain.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:debug (SteadyJack)
 **/

@Controller
public class SysPageController {

    @RequestMapping("modules/{module}/{page}.html")
    public String page(@PathVariable String module, @PathVariable String page, Integer courseId, ModelMap modelMap){
        if (courseId!=null && courseId>=0){
            modelMap.put("courseId",courseId);
        }
        return "modules/"+module+"/"+page;
    }

    /*@RequestMapping(value = {"index.html","/"} )
    public String index(){
        return "index";
    }*/
    @RequestMapping(value = {"index.html"} )
    public String index(){
        Object obj=SecurityUtils.getSubject().getPrincipal();
        if (obj!=null){
            SysUserEntity entity=(SysUserEntity) obj;
            if (entity!=null && entity.getType()==0){
                return "redirect:/";
            }
        }
        return "index";
    }

    @RequestMapping("login.html")
    public String login(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:index.html";
        }
        return "login";
    }
    @RequestMapping("register.html")
    public String register(){
        return "register";
    }
    @RequestMapping("main.html")
    public String main(){
        return "main";
    }

    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }


}