package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.SysPost;

import java.util.List;

public interface SysPostMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    SysPost selectByPrimaryKey(Long postId);

    List<SysPost> selectAll();

    int updateByPrimaryKey(SysPost record);
}