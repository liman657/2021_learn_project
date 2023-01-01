package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaTableStatistics;
import java.util.List;

public interface XSchemaTableStatisticsMapper {
    int insert(XSchemaTableStatistics record);

    List<XSchemaTableStatistics> selectAll();
}