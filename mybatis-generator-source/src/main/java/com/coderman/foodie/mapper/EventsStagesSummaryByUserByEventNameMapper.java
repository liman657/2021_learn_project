package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesSummaryByUserByEventName;
import java.util.List;

public interface EventsStagesSummaryByUserByEventNameMapper {
    int insert(EventsStagesSummaryByUserByEventName record);

    List<EventsStagesSummaryByUserByEventName> selectAll();
}