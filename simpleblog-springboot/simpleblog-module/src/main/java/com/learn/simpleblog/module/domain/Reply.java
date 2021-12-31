package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Reply implements Serializable{
    private Integer id;

    private Integer blogId;

    private Integer commentId;

    private Integer userId;

    private String content;

    private String replyFrom;

    private String replyTo;

    private Date replyTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String headerImg;

    public Reply(Integer blogId, Integer commentId, Integer userId, String content, String replyFrom, Date replyTime, Integer status) {
        this.blogId = blogId;
        this.commentId = commentId;
        this.userId = userId;
        this.content = content;
        this.replyFrom = replyFrom;
        this.replyTime = replyTime;
        this.status = status;
    }
}