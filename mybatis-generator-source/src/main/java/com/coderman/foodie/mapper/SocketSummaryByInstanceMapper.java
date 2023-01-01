package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SocketSummaryByInstance;
import java.util.List;

public interface SocketSummaryByInstanceMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(SocketSummaryByInstance record);

    SocketSummaryByInstance selectByPrimaryKey(Long objectInstanceBegin);

    List<SocketSummaryByInstance> selectAll();

    int updateByPrimaryKey(SocketSummaryByInstance record);
}