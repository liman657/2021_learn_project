package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserVariablesByThread;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVariablesByThreadMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    int insert(UserVariablesByThread record);

    UserVariablesByThread selectByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    List<UserVariablesByThread> selectAll();

    int updateByPrimaryKey(UserVariablesByThread record);
}