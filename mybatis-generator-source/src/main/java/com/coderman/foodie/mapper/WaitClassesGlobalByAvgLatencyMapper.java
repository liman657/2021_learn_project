package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.WaitClassesGlobalByAvgLatency;
import java.util.List;

public interface WaitClassesGlobalByAvgLatencyMapper {
    int insert(WaitClassesGlobalByAvgLatency record);

    List<WaitClassesGlobalByAvgLatency> selectAll();
}