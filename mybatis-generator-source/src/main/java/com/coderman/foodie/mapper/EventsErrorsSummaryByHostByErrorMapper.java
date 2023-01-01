package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsErrorsSummaryByHostByError;
import java.util.List;

public interface EventsErrorsSummaryByHostByErrorMapper {
    int insert(EventsErrorsSummaryByHostByError record);

    List<EventsErrorsSummaryByHostByError> selectAll();
}