package com.learn.simpleblog.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 前端用户注册
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class UserRequest implements Serializable{

    private Long userId;

    //@NotBlank(message="用户名不能为空!")
    private String username;

    //@NotBlank(message="用户昵称不能为空!")
    private String name="游客";

    @NotBlank(message="用户密码不能为空!")
    private String password;

    @NotBlank(message="邮箱不能为空!")
    private String email;

    private Integer status;

    //身份类型-0为前端注册上来的普通大众;1-为后端管理平台新增的人员
    private Integer type;

    private String imgUrl;
}

































