package com.learn.redisson.module.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
public class SysConfig implements Serializable{
    private Integer id;

    @NotBlank(message = "字典类型不能为空！")
    private String type;

    @NotBlank(message = "字典名称不能为空！")
    private String name;

    @NotBlank(message = "选项编码不能为空！")
    private String code;

    @NotBlank(message = "选项名称不能为空！")
    private String value;

    private Integer orderBy;

    private Byte isActive=1;

    private Date createTime;

}