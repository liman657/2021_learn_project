package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.BlogImage;

import java.util.List;

public interface BlogImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogImage record);

    BlogImage selectByPrimaryKey(Integer id);

    List<BlogImage> selectAll();

    int updateByPrimaryKey(BlogImage record);
}