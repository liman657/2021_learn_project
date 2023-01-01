package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierStatusByWorker;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplicationApplierStatusByWorkerMapper {
    int deleteByPrimaryKey(@Param("channelName") String channelName, @Param("workerId") Long workerId);

    int insert(ReplicationApplierStatusByWorker record);

    ReplicationApplierStatusByWorker selectByPrimaryKey(@Param("channelName") String channelName, @Param("workerId") Long workerId);

    List<ReplicationApplierStatusByWorker> selectAll();

    int updateByPrimaryKey(ReplicationApplierStatusByWorker record);
}