package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SocketInstances;
import java.util.List;

public interface SocketInstancesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(SocketInstances record);

    SocketInstances selectByPrimaryKey(Long objectInstanceBegin);

    List<SocketInstances> selectAll();

    int updateByPrimaryKey(SocketInstances record);
}