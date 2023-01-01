package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByThreadByEventName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStatementsSummaryByThreadByEventNameMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    int insert(EventsStatementsSummaryByThreadByEventName record);

    EventsStatementsSummaryByThreadByEventName selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    List<EventsStatementsSummaryByThreadByEventName> selectAll();

    int updateByPrimaryKey(EventsStatementsSummaryByThreadByEventName record);
}