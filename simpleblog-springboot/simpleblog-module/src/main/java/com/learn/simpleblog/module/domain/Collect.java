package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Collect implements Serializable{
    private Integer id;

    private Integer blogId;

    private Integer userId;

    private Date collectTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Collect(Integer blogId, Integer userId, Date collectTime, Integer status) {
        this.blogId = blogId;
        this.userId = userId;
        this.collectTime = collectTime;
        this.status = status;
    }
}