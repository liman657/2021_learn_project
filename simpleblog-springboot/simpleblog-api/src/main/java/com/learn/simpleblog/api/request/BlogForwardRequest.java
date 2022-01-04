package com.learn.simpleblog.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 转发微博
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class BlogForwardRequest implements Serializable{

    //@NotBlank(message = "转发内容不能为空！")
    private String content;

    @NotNull(message = "待转发微博id不能为空！")
    private Integer blogId;

}























