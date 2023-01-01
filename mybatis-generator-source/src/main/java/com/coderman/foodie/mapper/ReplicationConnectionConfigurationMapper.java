package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationConnectionConfiguration;
import java.util.List;

public interface ReplicationConnectionConfigurationMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(ReplicationConnectionConfiguration record);

    ReplicationConnectionConfiguration selectByPrimaryKey(String channelName);

    List<ReplicationConnectionConfiguration> selectAll();

    int updateByPrimaryKey(ReplicationConnectionConfiguration record);
}