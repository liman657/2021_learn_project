package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsHistoryLong;
import java.util.List;

public interface EventsStatementsHistoryLongMapper {
    int insert(EventsStatementsHistoryLong record);

    List<EventsStatementsHistoryLong> selectAll();
}