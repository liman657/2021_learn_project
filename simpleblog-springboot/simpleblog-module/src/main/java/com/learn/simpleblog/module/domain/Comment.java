package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Comment implements Serializable{
    private Integer id;

    private Integer blogId;

    private Integer userId;

    private String content;

    private Date commentTime;

    private Integer status;

    private Date updateTime;

    public Comment(Integer blogId, Integer userId, String content, Date commentTime, Integer status) {
        this.blogId = blogId;
        this.userId = userId;
        this.content = content;
        this.commentTime = commentTime;
        this.status = status;
    }


    private String nickName;

    private String headerImg;

    private List<Reply> replys;
}