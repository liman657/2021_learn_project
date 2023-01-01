package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.WaitsByUserByLatency;
import java.util.List;

public interface WaitsByUserByLatencyMapper {
    int insert(WaitsByUserByLatency record);

    List<WaitsByUserByLatency> selectAll();
}