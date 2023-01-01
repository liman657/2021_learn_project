package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XWaitClassesGlobalByAvgLatency;
import java.util.List;

public interface XWaitClassesGlobalByAvgLatencyMapper {
    int insert(XWaitClassesGlobalByAvgLatency record);

    List<XWaitClassesGlobalByAvgLatency> selectAll();
}