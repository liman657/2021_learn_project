package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

//菜单管理
@Data
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//菜单ID
	@TableId
	private Long menuId;

	//父菜单Id，顶级菜单为0
	//@NotNull(message = "父级菜单不能为空!")
	private Long parentId;
	
	//父菜单名称
	@TableField(exist=false)
	private String parentName;

	//菜单名称
	//@NotBlank(message = "菜单名称不能为空!")
	private String name;

	//菜单链接url
	private String url;

	//授权(多个用逗号分隔，如：user:list,user:create)
	private String perms;

	//类型= 0：目录   1：菜单   2：按钮
	private Integer type;

	//菜单图标
	private String icon;

	//排序
	private Integer orderNum;
	
	//ztree属性
	@TableField(exist=false)
	private Boolean open;

	@TableField(exist=false)
	private List<?> list;
}
