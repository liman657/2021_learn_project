package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaIndexStatistics;
import java.util.List;

public interface XSchemaIndexStatisticsMapper {
    int insert(XSchemaIndexStatistics record);

    List<XSchemaIndexStatistics> selectAll();
}