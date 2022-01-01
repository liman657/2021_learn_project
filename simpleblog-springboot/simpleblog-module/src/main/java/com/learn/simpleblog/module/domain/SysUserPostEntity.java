package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//用户与岗位关联关系
@Data
@TableName("sys_user_post")
public class SysUserPostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	//用户Id
	private Long userId;

	//岗位Id
	private Long postId;

	@TableField(exist = false)
	private String postName;
}
