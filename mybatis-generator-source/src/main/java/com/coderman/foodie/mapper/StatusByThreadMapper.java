package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatusByThread;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusByThreadMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    int insert(StatusByThread record);

    StatusByThread selectByPrimaryKey(@Param("threadId") Long threadId, @Param("variableName") String variableName);

    List<StatusByThread> selectAll();

    int updateByPrimaryKey(StatusByThread record);
}