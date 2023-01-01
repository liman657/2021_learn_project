package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesSummaryByThreadByEventName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStagesSummaryByThreadByEventNameMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    int insert(EventsStagesSummaryByThreadByEventName record);

    EventsStagesSummaryByThreadByEventName selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    List<EventsStagesSummaryByThreadByEventName> selectAll();

    int updateByPrimaryKey(EventsStagesSummaryByThreadByEventName record);
}