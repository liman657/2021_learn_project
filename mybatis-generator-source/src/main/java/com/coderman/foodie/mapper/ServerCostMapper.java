package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ServerCost;
import java.util.List;

public interface ServerCostMapper {
    int deleteByPrimaryKey(String costName);

    int insert(ServerCost record);

    ServerCost selectByPrimaryKey(String costName);

    List<ServerCost> selectAll();

    int updateByPrimaryKey(ServerCost record);
}