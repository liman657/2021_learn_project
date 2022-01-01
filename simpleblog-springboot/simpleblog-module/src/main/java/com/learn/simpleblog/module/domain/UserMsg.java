package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserMsg implements Serializable{
    private Integer id;

    private String module;

    private Integer moduleId;

    private String content;

    private Integer isRead=0;

    private Date readTime;

    private Integer receiverId;

    private Date createTime;

    private Integer isDelete=0;

    private Date deleteTime;

    private Date updateTime;

    public UserMsg(String module, Integer moduleId, String content, Integer isRead, Integer receiverId, Date createTime) {
        this.module = module;
        this.moduleId = moduleId;
        this.content = content;
        this.isRead = isRead;
        this.receiverId = receiverId;
        this.createTime = createTime;
    }
}