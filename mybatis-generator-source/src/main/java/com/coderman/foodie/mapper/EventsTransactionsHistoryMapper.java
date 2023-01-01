package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsHistory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsTransactionsHistoryMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsTransactionsHistory record);

    EventsTransactionsHistory selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsTransactionsHistory> selectAll();

    int updateByPrimaryKey(EventsTransactionsHistory record);
}