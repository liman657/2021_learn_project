package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SlaveMasterInfo;
import java.util.List;

public interface SlaveMasterInfoMapper {
    int deleteByPrimaryKey(String channelName);

    int insert(SlaveMasterInfo record);

    SlaveMasterInfo selectByPrimaryKey(String channelName);

    List<SlaveMasterInfo> selectAll();

    int updateByPrimaryKey(SlaveMasterInfo record);
}