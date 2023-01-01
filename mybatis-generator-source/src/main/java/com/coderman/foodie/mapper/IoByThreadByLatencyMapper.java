package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.IoByThreadByLatency;
import java.util.List;

public interface IoByThreadByLatencyMapper {
    int insert(IoByThreadByLatency record);

    List<IoByThreadByLatency> selectAll();
}