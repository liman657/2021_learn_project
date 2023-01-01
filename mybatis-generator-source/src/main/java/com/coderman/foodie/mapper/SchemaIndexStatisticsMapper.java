package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaIndexStatistics;
import java.util.List;

public interface SchemaIndexStatisticsMapper {
    int insert(SchemaIndexStatistics record);

    List<SchemaIndexStatistics> selectAll();
}