package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierStatus;
import java.util.List;

public interface ReplicationApplierStatusMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(ReplicationApplierStatus record);

    ReplicationApplierStatus selectByPrimaryKey(String channelName);

    List<ReplicationApplierStatus> selectAll();

    int updateByPrimaryKey(ReplicationApplierStatus record);
}