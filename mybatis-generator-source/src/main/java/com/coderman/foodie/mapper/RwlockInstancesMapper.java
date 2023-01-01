package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.RwlockInstances;
import java.util.List;

public interface RwlockInstancesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(RwlockInstances record);

    RwlockInstances selectByPrimaryKey(Long objectInstanceBegin);

    List<RwlockInstances> selectAll();

    int updateByPrimaryKey(RwlockInstances record);
}