package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysPost;
import java.util.List;

public interface SysPostMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    SysPost selectByPrimaryKey(Long postId);

    List<SysPost> selectAll();

    int updateByPrimaryKey(SysPost record);
}