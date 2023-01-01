package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryByHostByEventName;
import java.util.List;

public interface EventsWaitsSummaryByHostByEventNameMapper {
    int insert(EventsWaitsSummaryByHostByEventName record);

    List<EventsWaitsSummaryByHostByEventName> selectAll();
}