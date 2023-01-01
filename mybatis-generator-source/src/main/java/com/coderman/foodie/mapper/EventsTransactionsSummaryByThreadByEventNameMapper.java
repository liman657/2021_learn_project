package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsSummaryByThreadByEventName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsTransactionsSummaryByThreadByEventNameMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    int insert(EventsTransactionsSummaryByThreadByEventName record);

    EventsTransactionsSummaryByThreadByEventName selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    List<EventsTransactionsSummaryByThreadByEventName> selectAll();

    int updateByPrimaryKey(EventsTransactionsSummaryByThreadByEventName record);
}