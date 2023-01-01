package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Func;
import java.util.List;

public interface FuncMapper {
    int deleteByPrimaryKey(String name);

    int insert(Func record);

    Func selectByPrimaryKey(String name);

    List<Func> selectAll();

    int updateByPrimaryKey(Func record);
}