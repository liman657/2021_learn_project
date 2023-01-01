package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsErrorsSummaryByUserByError;
import java.util.List;

public interface EventsErrorsSummaryByUserByErrorMapper {
    int insert(EventsErrorsSummaryByUserByError record);

    List<EventsErrorsSummaryByUserByError> selectAll();
}