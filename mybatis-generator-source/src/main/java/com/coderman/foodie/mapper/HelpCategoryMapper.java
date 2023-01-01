package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HelpCategory;
import java.util.List;

public interface HelpCategoryMapper {
    int deleteByPrimaryKey(Short helpCategoryId);

    int insert(HelpCategory record);

    HelpCategory selectByPrimaryKey(Short helpCategoryId);

    List<HelpCategory> selectAll();

    int updateByPrimaryKey(HelpCategory record);
}