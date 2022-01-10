package com.learn.simpleblog.module.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2021/1/6 21:01
 **/
@Data
public class BlogImageDto implements Serializable{

    private Integer id;

    private String fileUrl;
}