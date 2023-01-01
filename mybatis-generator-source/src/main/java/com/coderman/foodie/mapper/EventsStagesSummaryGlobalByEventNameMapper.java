package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesSummaryGlobalByEventName;
import java.util.List;

public interface EventsStagesSummaryGlobalByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(EventsStagesSummaryGlobalByEventName record);

    EventsStagesSummaryGlobalByEventName selectByPrimaryKey(String eventName);

    List<EventsStagesSummaryGlobalByEventName> selectAll();

    int updateByPrimaryKey(EventsStagesSummaryGlobalByEventName record);
}