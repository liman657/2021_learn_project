package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.GlobalVariables;
import java.util.List;

public interface GlobalVariablesMapper {
    int deleteByPrimaryKey(String variableName);

    int insert(GlobalVariables record);

    GlobalVariables selectByPrimaryKey(String variableName);

    List<GlobalVariables> selectAll();

    int updateByPrimaryKey(GlobalVariables record);
}