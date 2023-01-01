package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryByInstance;
import java.util.List;

public interface EventsWaitsSummaryByInstanceMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(EventsWaitsSummaryByInstance record);

    EventsWaitsSummaryByInstance selectByPrimaryKey(Long objectInstanceBegin);

    List<EventsWaitsSummaryByInstance> selectAll();

    int updateByPrimaryKey(EventsWaitsSummaryByInstance record);
}