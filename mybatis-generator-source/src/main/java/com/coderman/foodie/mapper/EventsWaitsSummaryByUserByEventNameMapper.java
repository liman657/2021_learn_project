package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryByUserByEventName;
import java.util.List;

public interface EventsWaitsSummaryByUserByEventNameMapper {
    int insert(EventsWaitsSummaryByUserByEventName record);

    List<EventsWaitsSummaryByUserByEventName> selectAll();
}