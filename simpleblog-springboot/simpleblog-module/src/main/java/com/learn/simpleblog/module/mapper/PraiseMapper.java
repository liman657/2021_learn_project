package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Praise;
import org.apache.ibatis.annotations.Param;

public interface PraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Praise record);

    int insertSelective(Praise record);

    Praise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);

    Praise selectByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);

    int countByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);

    int deleteByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);
}