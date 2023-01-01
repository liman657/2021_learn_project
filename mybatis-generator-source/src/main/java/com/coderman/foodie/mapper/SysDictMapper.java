package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysDict;
import java.util.List;

public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    List<SysDict> selectAll();

    int updateByPrimaryKey(SysDict record);
}