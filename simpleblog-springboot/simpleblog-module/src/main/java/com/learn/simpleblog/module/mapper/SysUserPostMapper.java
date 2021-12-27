package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.SysUserPost;

import java.util.List;

public interface SysUserPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserPost record);

    SysUserPost selectByPrimaryKey(Integer id);

    List<SysUserPost> selectAll();

    int updateByPrimaryKey(SysUserPost record);
}