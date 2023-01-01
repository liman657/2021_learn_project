package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Metrics;
import java.util.List;

public interface MetricsMapper {
    int insert(Metrics record);

    List<Metrics> selectAll();
}