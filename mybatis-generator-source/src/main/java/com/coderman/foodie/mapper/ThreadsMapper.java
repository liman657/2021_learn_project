package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Threads;
import java.util.List;

public interface ThreadsMapper {
    int deleteByPrimaryKey(Long threadId);

    int insert(Threads record);

    Threads selectByPrimaryKey(Long threadId);

    List<Threads> selectAll();

    int updateByPrimaryKey(Threads record);
}