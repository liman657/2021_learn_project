package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaTableStatistics;
import java.util.List;

public interface SchemaTableStatisticsMapper {
    int insert(SchemaTableStatistics record);

    List<SchemaTableStatistics> selectAll();
}