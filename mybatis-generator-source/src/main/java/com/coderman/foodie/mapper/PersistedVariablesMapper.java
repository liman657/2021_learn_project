package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.PersistedVariables;
import java.util.List;

public interface PersistedVariablesMapper {
    int deleteByPrimaryKey(String variableName);

    int insert(PersistedVariables record);

    PersistedVariables selectByPrimaryKey(String variableName);

    List<PersistedVariables> selectAll();

    int updateByPrimaryKey(PersistedVariables record);
}