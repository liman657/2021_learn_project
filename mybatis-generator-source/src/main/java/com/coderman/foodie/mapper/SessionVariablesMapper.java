package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SessionVariables;
import java.util.List;

public interface SessionVariablesMapper {
    int deleteByPrimaryKey(String variableName);

    int insert(SessionVariables record);

    SessionVariables selectByPrimaryKey(String variableName);

    List<SessionVariables> selectAll();

    int updateByPrimaryKey(SessionVariables record);
}