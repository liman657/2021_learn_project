package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

//部门实体
@Data
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//部门主键ID
	@TableId
	private Long deptId;

	//上级部门ID，一级部门为0
	@NotNull(message = "父级部门必填!")
	private Long parentId;

	//部门名称
	@NotBlank(message = "部门名称不能为空!")
	private String name;

	//上级部门名称
	@TableField(exist=false)
	private String parentName;

	//排序编号
	private Integer orderNum;

	//删除标记
	@TableLogic
	private Integer delFlag;

	/**
	 * ztree属性
	 */
	@TableField(exist=false)
	private Boolean open;

	@TableField(exist=false)
	private List<?> list;
}
