package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XIoGlobalByFileByLatency;
import java.util.List;

public interface XIoGlobalByFileByLatencyMapper {
    int insert(XIoGlobalByFileByLatency record);

    List<XIoGlobalByFileByLatency> selectAll();
}