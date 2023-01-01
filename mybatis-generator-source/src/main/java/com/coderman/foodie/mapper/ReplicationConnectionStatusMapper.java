package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationConnectionStatus;
import java.util.List;

public interface ReplicationConnectionStatusMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(ReplicationConnectionStatus record);

    ReplicationConnectionStatus selectByPrimaryKey(String channelName);

    List<ReplicationConnectionStatus> selectAll();

    int updateByPrimaryKey(ReplicationConnectionStatus record);
}