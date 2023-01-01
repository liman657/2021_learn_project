package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcClassvalue;
import java.util.List;

public interface ImcClassvalueMapper {
    int deleteByPrimaryKey(Integer valueId);

    int insert(ImcClassvalue record);

    ImcClassvalue selectByPrimaryKey(Integer valueId);

    List<ImcClassvalue> selectAll();

    int updateByPrimaryKey(ImcClassvalue record);
}