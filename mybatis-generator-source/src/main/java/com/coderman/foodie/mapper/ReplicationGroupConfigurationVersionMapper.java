package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationGroupConfigurationVersion;
import java.util.List;

public interface ReplicationGroupConfigurationVersionMapper {
    int deleteByPrimaryKey(String name);

    int insert(ReplicationGroupConfigurationVersion record);

    ReplicationGroupConfigurationVersion selectByPrimaryKey(String name);

    List<ReplicationGroupConfigurationVersion> selectAll();

    int updateByPrimaryKey(ReplicationGroupConfigurationVersion record);
}