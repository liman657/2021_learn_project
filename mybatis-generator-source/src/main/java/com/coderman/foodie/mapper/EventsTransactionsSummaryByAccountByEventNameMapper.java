package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsSummaryByAccountByEventName;
import java.util.List;

public interface EventsTransactionsSummaryByAccountByEventNameMapper {
    int insert(EventsTransactionsSummaryByAccountByEventName record);

    List<EventsTransactionsSummaryByAccountByEventName> selectAll();
}