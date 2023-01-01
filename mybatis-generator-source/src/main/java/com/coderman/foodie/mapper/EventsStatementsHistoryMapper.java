package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsHistory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStatementsHistoryMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsStatementsHistory record);

    EventsStatementsHistory selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsStatementsHistory> selectAll();

    int updateByPrimaryKey(EventsStatementsHistory record);
}