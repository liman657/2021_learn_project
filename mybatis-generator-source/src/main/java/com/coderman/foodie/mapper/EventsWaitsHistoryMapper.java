package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsHistory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsWaitsHistoryMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsWaitsHistory record);

    EventsWaitsHistory selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsWaitsHistory> selectAll();

    int updateByPrimaryKey(EventsWaitsHistory record);
}