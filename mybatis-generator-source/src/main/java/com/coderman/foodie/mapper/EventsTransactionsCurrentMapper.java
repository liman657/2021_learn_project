package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsTransactionsCurrent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsTransactionsCurrentMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    int insert(EventsTransactionsCurrent record);

    EventsTransactionsCurrent selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventId") Long eventId);

    List<EventsTransactionsCurrent> selectAll();

    int updateByPrimaryKey(EventsTransactionsCurrent record);
}