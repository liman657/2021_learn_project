package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

//岗位实体
@Data
@TableName("sys_post")
public class SysPostEntity implements Serializable{

    @TableId
    private Long postId;

    @NotBlank(message = "岗位编码不能为空!")
    private String postCode;

    @NotBlank(message = "岗位名称不能为空!")
    private String postName;

    private Integer orderNum;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    private String remark;

}