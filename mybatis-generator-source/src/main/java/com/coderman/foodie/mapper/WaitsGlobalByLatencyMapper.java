package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.WaitsGlobalByLatency;
import java.util.List;

public interface WaitsGlobalByLatencyMapper {
    int insert(WaitsGlobalByLatency record);

    List<WaitsGlobalByLatency> selectAll();
}