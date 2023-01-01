package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemorySummaryByThreadByEventName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemorySummaryByThreadByEventNameMapper {
    int deleteByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    int insert(MemorySummaryByThreadByEventName record);

    MemorySummaryByThreadByEventName selectByPrimaryKey(@Param("threadId") Long threadId, @Param("eventName") String eventName);

    List<MemorySummaryByThreadByEventName> selectAll();

    int updateByPrimaryKey(MemorySummaryByThreadByEventName record);
}