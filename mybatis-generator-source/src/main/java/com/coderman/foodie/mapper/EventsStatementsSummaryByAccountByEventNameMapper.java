package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByAccountByEventName;
import java.util.List;

public interface EventsStatementsSummaryByAccountByEventNameMapper {
    int insert(EventsStatementsSummaryByAccountByEventName record);

    List<EventsStatementsSummaryByAccountByEventName> selectAll();
}