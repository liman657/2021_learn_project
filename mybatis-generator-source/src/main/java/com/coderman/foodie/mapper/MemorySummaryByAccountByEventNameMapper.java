package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemorySummaryByAccountByEventName;
import java.util.List;

public interface MemorySummaryByAccountByEventNameMapper {
    int insert(MemorySummaryByAccountByEventName record);

    List<MemorySummaryByAccountByEventName> selectAll();
}