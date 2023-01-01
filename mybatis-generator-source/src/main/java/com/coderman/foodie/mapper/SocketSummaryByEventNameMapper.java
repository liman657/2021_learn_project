package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SocketSummaryByEventName;
import java.util.List;

public interface SocketSummaryByEventNameMapper {
    int deleteByPrimaryKey(String eventName);

    int insert(SocketSummaryByEventName record);

    SocketSummaryByEventName selectByPrimaryKey(String eventName);

    List<SocketSummaryByEventName> selectAll();

    int updateByPrimaryKey(SocketSummaryByEventName record);
}