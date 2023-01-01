package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsHistogramGlobal;
import java.util.List;

public interface EventsStatementsHistogramGlobalMapper {
    int deleteByPrimaryKey(Integer bucketNumber);

    int insert(EventsStatementsHistogramGlobal record);

    EventsStatementsHistogramGlobal selectByPrimaryKey(Integer bucketNumber);

    List<EventsStatementsHistogramGlobal> selectAll();

    int updateByPrimaryKey(EventsStatementsHistogramGlobal record);
}