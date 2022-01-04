package com.learn.simpleblog.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 发微博
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class BlogRequest implements Serializable{

    @NotBlank(message = "微博内容不能为空！")
    private String content;

    //支持多张;有多张时采用 , 拼接成字符串传递过来
    private String imgIds;

}























