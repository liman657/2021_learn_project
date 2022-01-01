package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.simpleblog.module.domain.SysUserPostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

//用户与岗位关联关系
@Mapper
public interface SysUserPostDao extends BaseMapper<SysUserPostEntity> {
	
	//根据用户Id 获取角色Id列表
	List<Long> queryPostIdList(Long userId);

	//根据角色Id列表，批量删除
	int deleteBatch(@Param("roleIds") String roleIds);

	//根据用户id获取用户-岗位详情
	List<SysUserPostEntity> getByUserId(@Param("userId") Long userId);

	Set<String> getPostNamesByUserId(@Param("userId") Long userId);
}
