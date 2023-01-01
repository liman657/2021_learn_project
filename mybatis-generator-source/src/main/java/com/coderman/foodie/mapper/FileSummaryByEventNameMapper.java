package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FileSummaryByEventName;
import java.util.List;

public interface FileSummaryByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(FileSummaryByEventName record);

    FileSummaryByEventName selectByPrimaryKey(String eventName);

    List<FileSummaryByEventName> selectAll();

    int updateByPrimaryKey(FileSummaryByEventName record);
}