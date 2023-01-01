package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemorySummaryGlobalByEventName;
import java.util.List;

public interface MemorySummaryGlobalByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(MemorySummaryGlobalByEventName record);

    MemorySummaryGlobalByEventName selectByPrimaryKey(String eventName);

    List<MemorySummaryGlobalByEventName> selectAll();

    int updateByPrimaryKey(MemorySummaryGlobalByEventName record);
}