package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SlaveWorkerInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlaveWorkerInfoMapper {
    int deleteByPrimaryKey(@Param("channelName") String channelName, @Param("id") Integer id);

    int insert(SlaveWorkerInfo record);

    SlaveWorkerInfo selectByPrimaryKey(@Param("channelName") String channelName, @Param("id") Integer id);

    List<SlaveWorkerInfo> selectAll();

    int updateByPrimaryKey(SlaveWorkerInfo record);
}