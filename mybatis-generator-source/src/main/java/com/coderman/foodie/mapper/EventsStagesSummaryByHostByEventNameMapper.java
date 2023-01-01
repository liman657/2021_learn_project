package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesSummaryByHostByEventName;
import java.util.List;

public interface EventsStagesSummaryByHostByEventNameMapper {
    int insert(EventsStagesSummaryByHostByEventName record);

    List<EventsStagesSummaryByHostByEventName> selectAll();
}