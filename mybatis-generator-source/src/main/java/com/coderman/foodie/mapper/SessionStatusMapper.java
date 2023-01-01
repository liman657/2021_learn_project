package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SessionStatus;
import java.util.List;

public interface SessionStatusMapper {
    int deleteByPrimaryKey(String variableName);

    int insert(SessionStatus record);

    SessionStatus selectByPrimaryKey(String variableName);

    List<SessionStatus> selectAll();

    int updateByPrimaryKey(SessionStatus record);
}