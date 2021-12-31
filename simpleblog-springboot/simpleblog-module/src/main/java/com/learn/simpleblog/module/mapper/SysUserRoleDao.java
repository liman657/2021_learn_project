package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.simpleblog.module.domain.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//角色与用户关联关系
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
	//根据用户Id 获取角色Id列表
	List<Long> queryRoleIdList(Long userId);

	//根据角色Id列表，批量删除
	int deleteBatch(@Param("roleIds") String roleIds);
}
