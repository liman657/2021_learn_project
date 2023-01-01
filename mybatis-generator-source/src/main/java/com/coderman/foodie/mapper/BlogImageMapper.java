package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.BlogImage;
import java.util.List;

public interface BlogImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogImage record);

    BlogImage selectByPrimaryKey(Integer id);

    List<BlogImage> selectAll();

    int updateByPrimaryKey(BlogImage record);
}