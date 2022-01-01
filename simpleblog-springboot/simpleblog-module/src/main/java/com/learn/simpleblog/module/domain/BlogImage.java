package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class BlogImage implements Serializable{
    private Integer id;

    private Integer blogId;

    private String name;

    private String size;

    private String suffix;

    private String fileUrl;

    private Byte isActive=1;

    private Date createTime;

    public BlogImage(String name, String size, String suffix, String fileUrl) {
        this.name = name;
        this.size = size;
        this.suffix = suffix;
        this.fileUrl = fileUrl;
    }
}