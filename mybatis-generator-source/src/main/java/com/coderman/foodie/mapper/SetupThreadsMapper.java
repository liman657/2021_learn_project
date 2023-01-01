package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SetupThreads;
import java.util.List;

public interface SetupThreadsMapper {
    int deleteByPrimaryKey(String name);

    int insert(SetupThreads record);

    SetupThreads selectByPrimaryKey(String name);

    List<SetupThreads> selectAll();

    int updateByPrimaryKey(SetupThreads record);
}