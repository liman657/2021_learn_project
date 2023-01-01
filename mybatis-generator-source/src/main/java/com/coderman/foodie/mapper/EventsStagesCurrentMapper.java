package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStagesCurrent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStagesCurrentMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsStagesCurrent record);

    EventsStagesCurrent selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsStagesCurrent> selectAll();

    int updateByPrimaryKey(EventsStagesCurrent record);
}