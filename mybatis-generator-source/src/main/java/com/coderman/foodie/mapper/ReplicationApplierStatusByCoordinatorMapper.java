package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierStatusByCoordinator;
import java.util.List;

public interface ReplicationApplierStatusByCoordinatorMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(ReplicationApplierStatusByCoordinator record);

    ReplicationApplierStatusByCoordinator selectByPrimaryKey(String channelName);

    List<ReplicationApplierStatusByCoordinator> selectAll();

    int updateByPrimaryKey(ReplicationApplierStatusByCoordinator record);
}