package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsErrorsSummaryByThreadByError;
import java.util.List;

public interface EventsErrorsSummaryByThreadByErrorMapper {
    int insert(EventsErrorsSummaryByThreadByError record);

    List<EventsErrorsSummaryByThreadByError> selectAll();
}