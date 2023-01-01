package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryGlobalByEventName;
import java.util.List;

public interface EventsWaitsSummaryGlobalByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(EventsWaitsSummaryGlobalByEventName record);

    EventsWaitsSummaryGlobalByEventName selectByPrimaryKey(String eventName);

    List<EventsWaitsSummaryGlobalByEventName> selectAll();

    int updateByPrimaryKey(EventsWaitsSummaryGlobalByEventName record);
}