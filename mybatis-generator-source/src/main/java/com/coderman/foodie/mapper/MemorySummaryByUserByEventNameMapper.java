package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemorySummaryByUserByEventName;
import java.util.List;

public interface MemorySummaryByUserByEventNameMapper {
    int insert(MemorySummaryByUserByEventName record);

    List<MemorySummaryByUserByEventName> selectAll();
}