package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XWaitClassesGlobalByLatency;
import java.util.List;

public interface XWaitClassesGlobalByLatencyMapper {
    int insert(XWaitClassesGlobalByLatency record);

    List<XWaitClassesGlobalByLatency> selectAll();
}