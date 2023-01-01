package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryByAccountByEventName;
import java.util.List;

public interface EventsWaitsSummaryByAccountByEventNameMapper {
    int insert(EventsWaitsSummaryByAccountByEventName record);

    List<EventsWaitsSummaryByAccountByEventName> selectAll();
}