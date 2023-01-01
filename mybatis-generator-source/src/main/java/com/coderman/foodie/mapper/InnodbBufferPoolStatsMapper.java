package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbBufferPoolStats;
import java.util.List;

public interface InnodbBufferPoolStatsMapper {
    int insert(InnodbBufferPoolStats record);

    List<InnodbBufferPoolStats> selectAll();
}