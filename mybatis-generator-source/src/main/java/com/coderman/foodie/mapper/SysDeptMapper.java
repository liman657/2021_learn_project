package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysDept;
import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(Long deptId);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);
}