package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcCourse;
import java.util.List;

public interface ImcCourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(ImcCourse record);

    ImcCourse selectByPrimaryKey(Integer courseId);

    List<ImcCourse> selectAll();

    int updateByPrimaryKey(ImcCourse record);
}