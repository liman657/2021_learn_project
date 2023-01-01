package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsErrorsSummaryGlobalByError;
import java.util.List;

public interface EventsErrorsSummaryGlobalByErrorMapper {
    int insert(EventsErrorsSummaryGlobalByError record);

    List<EventsErrorsSummaryGlobalByError> selectAll();
}