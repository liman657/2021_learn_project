package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Stu;
import java.util.List;

public interface StuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    Stu selectByPrimaryKey(Integer id);

    List<Stu> selectAll();

    int updateByPrimaryKey(Stu record);
}