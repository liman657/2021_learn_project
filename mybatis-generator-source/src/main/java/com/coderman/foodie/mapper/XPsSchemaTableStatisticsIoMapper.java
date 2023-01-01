package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XPsSchemaTableStatisticsIo;
import java.util.List;

public interface XPsSchemaTableStatisticsIoMapper {
    int insert(XPsSchemaTableStatisticsIo record);

    List<XPsSchemaTableStatisticsIo> selectAll();
}