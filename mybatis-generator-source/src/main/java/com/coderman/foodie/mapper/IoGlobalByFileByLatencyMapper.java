package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.IoGlobalByFileByLatency;
import java.util.List;

public interface IoGlobalByFileByLatencyMapper {
    int insert(IoGlobalByFileByLatency record);

    List<IoGlobalByFileByLatency> selectAll();
}