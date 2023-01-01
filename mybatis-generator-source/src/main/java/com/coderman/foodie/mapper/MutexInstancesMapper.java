package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MutexInstances;
import java.util.List;

public interface MutexInstancesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(MutexInstances record);

    MutexInstances selectByPrimaryKey(Long objectInstanceBegin);

    List<MutexInstances> selectAll();

    int updateByPrimaryKey(MutexInstances record);
}