package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SlaveRelayLogInfo;
import java.util.List;

public interface SlaveRelayLogInfoMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(SlaveRelayLogInfo record);

    SlaveRelayLogInfo selectByPrimaryKey(String channelName);

    List<SlaveRelayLogInfo> selectAll();

    int updateByPrimaryKey(SlaveRelayLogInfo record);
}