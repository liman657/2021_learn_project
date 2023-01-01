package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesHistory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStagesHistoryMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsStagesHistory record);

    EventsStagesHistory selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsStagesHistory> selectAll();

    int updateByPrimaryKey(EventsStagesHistory record);
}