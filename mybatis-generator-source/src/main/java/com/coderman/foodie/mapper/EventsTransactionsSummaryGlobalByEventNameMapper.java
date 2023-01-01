package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsSummaryGlobalByEventName;
import java.util.List;

public interface EventsTransactionsSummaryGlobalByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(EventsTransactionsSummaryGlobalByEventName record);

    EventsTransactionsSummaryGlobalByEventName selectByPrimaryKey(String eventName);

    List<EventsTransactionsSummaryGlobalByEventName> selectAll();

    int updateByPrimaryKey(EventsTransactionsSummaryGlobalByEventName record);
}