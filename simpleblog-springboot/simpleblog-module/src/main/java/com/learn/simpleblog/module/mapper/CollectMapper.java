package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Collect;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    Collect selectByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);

    int countByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);

    int deleteByUBlogId(@Param("blogId") Integer blogId, @Param("userId") Long userId);
}