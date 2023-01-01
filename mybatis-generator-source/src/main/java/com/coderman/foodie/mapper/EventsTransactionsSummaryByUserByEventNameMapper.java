package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsSummaryByUserByEventName;
import java.util.List;

public interface EventsTransactionsSummaryByUserByEventNameMapper {
    int insert(EventsTransactionsSummaryByUserByEventName record);

    List<EventsTransactionsSummaryByUserByEventName> selectAll();
}