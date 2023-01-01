package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.WaitsByHostByLatency;
import java.util.List;

public interface WaitsByHostByLatencyMapper {
    int insert(WaitsByHostByLatency record);

    List<WaitsByHostByLatency> selectAll();
}