package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysUserPost;
import java.util.List;

public interface SysUserPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserPost record);

    SysUserPost selectByPrimaryKey(Integer id);

    List<SysUserPost> selectAll();

    int updateByPrimaryKey(SysUserPost record);
}