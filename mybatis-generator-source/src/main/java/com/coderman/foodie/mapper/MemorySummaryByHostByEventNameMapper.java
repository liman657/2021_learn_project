package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemorySummaryByHostByEventName;
import java.util.List;

public interface MemorySummaryByHostByEventNameMapper {
    int insert(MemorySummaryByHostByEventName record);

    List<MemorySummaryByHostByEventName> selectAll();
}