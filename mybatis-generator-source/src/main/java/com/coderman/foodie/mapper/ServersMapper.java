package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Servers;
import java.util.List;

public interface ServersMapper {
    int deleteByPrimaryKey(String serverName);

    int insert(Servers record);

    Servers selectByPrimaryKey(String serverName);

    List<Servers> selectAll();

    int updateByPrimaryKey(Servers record);
}