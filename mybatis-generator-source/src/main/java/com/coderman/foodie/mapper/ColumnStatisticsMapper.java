package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ColumnStatistics;
import java.util.List;

public interface ColumnStatisticsMapper {
    int insert(ColumnStatistics record);

    List<ColumnStatistics> selectAll();
}