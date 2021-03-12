package com.learn.redisson.module.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Item implements Serializable{

    private Integer id;

    @NotBlank(message = "商品编码不能为空！")
    private String code;

    @NotBlank(message = "商品名称不能为空！")
    private String name;

    private Date createTime;

    public Item(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}