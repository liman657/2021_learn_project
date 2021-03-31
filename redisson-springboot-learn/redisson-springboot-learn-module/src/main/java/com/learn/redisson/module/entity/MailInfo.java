package com.learn.redisson.module.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class MailInfo implements Serializable{
    private Integer id;

    @NotBlank(message = "邮件主题不能为空！")
    private String subject;

    @NotBlank(message = "邮件接受者不能为空！")
    private String tos;

    private Byte isActive=1;

    private Byte isDelay=0;

    private Date sendTime;

    private Date createTime;

    private Date updateTime;

    @NotBlank(message = "邮件内容不能为空！")
    private String content;



    private String sendDateTime;
}