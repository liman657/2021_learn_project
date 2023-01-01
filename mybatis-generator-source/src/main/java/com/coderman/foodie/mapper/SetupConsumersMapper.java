package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SetupConsumers;
import java.util.List;

public interface SetupConsumersMapper {
    int deleteByPrimaryKey(String name);

    int insert(SetupConsumers record);

    SetupConsumers selectByPrimaryKey(String name);

    List<SetupConsumers> selectAll();

    int updateByPrimaryKey(SetupConsumers record);
}