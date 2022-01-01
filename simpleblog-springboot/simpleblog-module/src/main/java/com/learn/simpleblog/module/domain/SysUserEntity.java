package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//用户实体
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TableId
	private Long userId;

	@NotBlank(message="用户名不能为空")
	private String username;

	private String name;

	private String password;

	private String salt;

	@NotBlank(message="邮箱不能为空!")
	private String email;

	private String mobile;

	private Integer status;

	//身份类型-0为前端注册上来的普通大众;1-为后端管理平台新增的人员
	private Integer type=0;

	private Date createTime;

	private Long deptId;

	private String imgUrl;



	//@TableField：字段属性不为数据库表字段，但又是必须使用的
	@TableField(exist=false)
	private List<Long> roleIdList;

	@TableField(exist=false)
	private String deptName;

	@TableField(exist=false)
	private List<Long> postIdList;

	@TableField(exist=false)
	private String postName;


}
