package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsSummaryByThreadByEventName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsWaitsSummaryByThreadByEventNameMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    int insert(EventsWaitsSummaryByThreadByEventName record);

    EventsWaitsSummaryByThreadByEventName selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    List<EventsWaitsSummaryByThreadByEventName> selectAll();

    int updateByPrimaryKey(EventsWaitsSummaryByThreadByEventName record);
}