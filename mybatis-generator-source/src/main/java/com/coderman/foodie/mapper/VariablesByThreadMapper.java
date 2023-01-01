package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.VariablesByThread;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VariablesByThreadMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    int insert(VariablesByThread record);

    VariablesByThread selectByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    List<VariablesByThread> selectAll();

    int updateByPrimaryKey(VariablesByThread record);
}