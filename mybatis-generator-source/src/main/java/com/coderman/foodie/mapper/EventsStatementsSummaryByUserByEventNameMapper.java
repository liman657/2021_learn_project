package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByUserByEventName;
import java.util.List;

public interface EventsStatementsSummaryByUserByEventNameMapper {
    int insert(EventsStatementsSummaryByUserByEventName record);

    List<EventsStatementsSummaryByUserByEventName> selectAll();
}