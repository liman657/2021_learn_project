package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsSummaryByHostByEventName;
import java.util.List;

public interface EventsTransactionsSummaryByHostByEventNameMapper {
    int insert(EventsTransactionsSummaryByHostByEventName record);

    List<EventsTransactionsSummaryByHostByEventName> selectAll();
}