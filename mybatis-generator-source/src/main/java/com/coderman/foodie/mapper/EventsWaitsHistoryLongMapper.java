package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsHistoryLong;
import java.util.List;

public interface EventsWaitsHistoryLongMapper {
    int insert(EventsWaitsHistoryLong record);

    List<EventsWaitsHistoryLong> selectAll();
}