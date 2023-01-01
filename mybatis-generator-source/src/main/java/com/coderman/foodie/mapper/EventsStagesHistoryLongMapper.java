package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesHistoryLong;
import java.util.List;

public interface EventsStagesHistoryLongMapper {
    int insert(EventsStagesHistoryLong record);

    List<EventsStagesHistoryLong> selectAll();
}