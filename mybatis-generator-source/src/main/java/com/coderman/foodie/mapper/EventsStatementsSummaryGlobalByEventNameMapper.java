package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryGlobalByEventName;
import java.util.List;

public interface EventsStatementsSummaryGlobalByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(EventsStatementsSummaryGlobalByEventName record);

    EventsStatementsSummaryGlobalByEventName selectByPrimaryKey(String eventName);

    List<EventsStatementsSummaryGlobalByEventName> selectAll();

    int updateByPrimaryKey(EventsStatementsSummaryGlobalByEventName record);
}