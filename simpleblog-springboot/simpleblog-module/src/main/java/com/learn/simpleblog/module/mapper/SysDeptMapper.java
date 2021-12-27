package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.SysDept;

import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(Long deptId);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);
}