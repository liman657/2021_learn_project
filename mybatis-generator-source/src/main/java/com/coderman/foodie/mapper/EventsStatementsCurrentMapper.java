package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsCurrent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStatementsCurrentMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsStatementsCurrent record);

    EventsStatementsCurrent selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsStatementsCurrent> selectAll();

    int updateByPrimaryKey(EventsStatementsCurrent record);
}