package com.learn.redisson.module.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductKill implements Serializable{
    private Integer id;

    private String prodCode;

    private Integer total;

    private Byte isActive;

    private Date createTime;


    //临时字段
    private String prodName;
}