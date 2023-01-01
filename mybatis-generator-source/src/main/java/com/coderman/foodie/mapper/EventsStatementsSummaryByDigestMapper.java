package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByDigest;
import java.util.List;

public interface EventsStatementsSummaryByDigestMapper {
    int insert(EventsStatementsSummaryByDigest record);

    List<EventsStatementsSummaryByDigest> selectAll();
}