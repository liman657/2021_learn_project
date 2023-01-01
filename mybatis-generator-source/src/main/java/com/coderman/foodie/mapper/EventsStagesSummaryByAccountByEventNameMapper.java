package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesSummaryByAccountByEventName;
import java.util.List;

public interface EventsStagesSummaryByAccountByEventNameMapper {
    int insert(EventsStagesSummaryByAccountByEventName record);

    List<EventsStagesSummaryByAccountByEventName> selectAll();
}