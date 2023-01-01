package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsHistoryLong;
import java.util.List;

public interface EventsTransactionsHistoryLongMapper {
    int insert(EventsTransactionsHistoryLong record);

    List<EventsTransactionsHistoryLong> selectAll();
}