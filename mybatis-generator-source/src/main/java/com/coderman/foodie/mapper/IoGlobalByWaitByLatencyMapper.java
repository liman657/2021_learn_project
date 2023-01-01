package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.IoGlobalByWaitByLatency;
import java.util.List;

public interface IoGlobalByWaitByLatencyMapper {
    int insert(IoGlobalByWaitByLatency record);

    List<IoGlobalByWaitByLatency> selectAll();
}