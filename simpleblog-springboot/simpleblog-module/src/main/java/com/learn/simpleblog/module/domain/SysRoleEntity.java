package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//角色实体
@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId
	private Long roleId;

	@NotBlank(message="角色名称不能为空")
	private String roleName;

	private String remark;

	@TableField(exist=false)
	private List<Long> menuIdList;

	@TableField(exist=false)
	private List<Long> deptIdList;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
}
