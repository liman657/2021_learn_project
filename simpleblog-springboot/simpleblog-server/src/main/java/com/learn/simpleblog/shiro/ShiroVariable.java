package com.learn.simpleblog.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * 推送给前端使用的shiro对象变量
 * @Author:liman
 **/
@Component
public class ShiroVariable {

    /**
     * 判断当前登录用户（主体）是否有 指定的权限
     * @param permission 指定的权限
     * @return
     */
    public Boolean hasPermission(String permission){
        Subject subject= SecurityUtils.getSubject();

        return (subject!=null && subject.isPermitted(permission))? true : false;
    }

}


























