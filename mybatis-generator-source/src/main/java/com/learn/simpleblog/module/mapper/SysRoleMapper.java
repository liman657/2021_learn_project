package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.SysRole;
import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);
}