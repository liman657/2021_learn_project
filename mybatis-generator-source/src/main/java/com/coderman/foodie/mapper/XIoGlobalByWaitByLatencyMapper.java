package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XIoGlobalByWaitByLatency;
import java.util.List;

public interface XIoGlobalByWaitByLatencyMapper {
    int insert(XIoGlobalByWaitByLatency record);

    List<XIoGlobalByWaitByLatency> selectAll();
}