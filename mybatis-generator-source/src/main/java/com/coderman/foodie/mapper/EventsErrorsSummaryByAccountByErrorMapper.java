package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsErrorsSummaryByAccountByError;
import java.util.List;

public interface EventsErrorsSummaryByAccountByErrorMapper {
    int insert(EventsErrorsSummaryByAccountByError record);

    List<EventsErrorsSummaryByAccountByError> selectAll();
}