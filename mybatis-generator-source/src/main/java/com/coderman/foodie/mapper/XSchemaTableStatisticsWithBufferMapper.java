package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaTableStatisticsWithBuffer;
import java.util.List;

public interface XSchemaTableStatisticsWithBufferMapper {
    int insert(XSchemaTableStatisticsWithBuffer record);

    List<XSchemaTableStatisticsWithBuffer> selectAll();
}