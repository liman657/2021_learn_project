package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XWaitsGlobalByLatency;
import java.util.List;

public interface XWaitsGlobalByLatencyMapper {
    int insert(XWaitsGlobalByLatency record);

    List<XWaitsGlobalByLatency> selectAll();
}