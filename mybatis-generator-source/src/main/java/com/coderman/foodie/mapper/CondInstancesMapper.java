package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.CondInstances;
import java.util.List;

public interface CondInstancesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(CondInstances record);

    CondInstances selectByPrimaryKey(Long objectInstanceBegin);

    List<CondInstances> selectAll();

    int updateByPrimaryKey(CondInstances record);
}