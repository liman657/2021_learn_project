package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.WaitClassesGlobalByLatency;
import java.util.List;

public interface WaitClassesGlobalByLatencyMapper {
    int insert(WaitClassesGlobalByLatency record);

    List<WaitClassesGlobalByLatency> selectAll();
}