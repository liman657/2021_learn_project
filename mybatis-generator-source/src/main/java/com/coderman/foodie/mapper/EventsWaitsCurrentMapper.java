package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsWaitsCurrent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsWaitsCurrentMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsWaitsCurrent record);

    EventsWaitsCurrent selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsWaitsCurrent> selectAll();

    int updateByPrimaryKey(EventsWaitsCurrent record);
}