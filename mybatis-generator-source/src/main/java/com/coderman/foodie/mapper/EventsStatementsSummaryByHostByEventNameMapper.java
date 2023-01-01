package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByHostByEventName;
import java.util.List;

public interface EventsStatementsSummaryByHostByEventNameMapper {
    int insert(EventsStatementsSummaryByHostByEventName record);

    List<EventsStatementsSummaryByHostByEventName> selectAll();
}