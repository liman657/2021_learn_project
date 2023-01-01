package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierConfiguration;
import java.util.List;

public interface ReplicationApplierConfigurationMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(ReplicationApplierConfiguration record);

    ReplicationApplierConfiguration selectByPrimaryKey(String channelName);

    List<ReplicationApplierConfiguration> selectAll();

    int updateByPrimaryKey(ReplicationApplierConfiguration record);
}