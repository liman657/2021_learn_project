package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcSelectcourse;
import java.util.List;

public interface ImcSelectcourseMapper {
    int deleteByPrimaryKey(Integer selectId);

    int insert(ImcSelectcourse record);

    ImcSelectcourse selectByPrimaryKey(Integer selectId);

    List<ImcSelectcourse> selectAll();

    int updateByPrimaryKey(ImcSelectcourse record);
}