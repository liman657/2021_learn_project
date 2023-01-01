package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XIoByThreadByLatency;
import java.util.List;

public interface XIoByThreadByLatencyMapper {
    int insert(XIoByThreadByLatency record);

    List<XIoByThreadByLatency> selectAll();
}