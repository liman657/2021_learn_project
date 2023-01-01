package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaTableStatisticsWithBuffer;
import java.util.List;

public interface SchemaTableStatisticsWithBufferMapper {
    int insert(SchemaTableStatisticsWithBuffer record);

    List<SchemaTableStatisticsWithBuffer> selectAll();
}