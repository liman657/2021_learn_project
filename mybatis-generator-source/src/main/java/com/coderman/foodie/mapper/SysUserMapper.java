package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);
}