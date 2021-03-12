package com.learn.redisson.module.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class Notice implements Serializable{
    private Integer id;

    @NotBlank(message = "通告标题不能为空！")
    private String title;

    @NotBlank(message = "通告内容不能为空！")
    private String content;

    private Byte isActive=1;
}