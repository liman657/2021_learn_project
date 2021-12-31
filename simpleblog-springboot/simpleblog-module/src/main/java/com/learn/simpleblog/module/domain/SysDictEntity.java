
package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

//数据字典
@Data
@TableName("sys_dict")
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	@NotBlank(message="字典名称不能为空")
	private String name;

	@NotBlank(message="字典类型不能为空")
	private String type;

	@NotBlank(message="字典码不能为空")
	private String code;

	@NotBlank(message="字典值不能为空")
	private String value;

	private Integer orderNum;

	private String remark;

	@TableLogic
	private Integer delFlag;

}
