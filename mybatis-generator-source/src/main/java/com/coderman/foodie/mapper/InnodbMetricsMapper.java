package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbMetrics;
import java.util.List;

public interface InnodbMetricsMapper {
    int insert(InnodbMetrics record);

    List<InnodbMetrics> selectAll();
}