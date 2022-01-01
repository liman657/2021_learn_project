package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Praise implements Serializable{
    private Integer id;

    private Integer blogId;

    private Integer userId;

    private Date praiseTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Praise(Integer blogId, Integer userId, Date praiseTime, Integer status) {
        this.blogId = blogId;
        this.userId = userId;
        this.praiseTime = praiseTime;
        this.status = status;
    }
}