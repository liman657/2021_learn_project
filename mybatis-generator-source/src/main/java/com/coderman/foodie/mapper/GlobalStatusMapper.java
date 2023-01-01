package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.GlobalStatus;
import java.util.List;

public interface GlobalStatusMapper {
    int deleteByPrimaryKey(String variableName);

    int insert(GlobalStatus record);

    GlobalStatus selectByPrimaryKey(String variableName);

    List<GlobalStatus> selectAll();

    int updateByPrimaryKey(GlobalStatus record);
}