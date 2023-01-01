package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsHistogramByDigest;
import java.util.List;

public interface EventsStatementsHistogramByDigestMapper {
    int insert(EventsStatementsHistogramByDigest record);

    List<EventsStatementsHistogramByDigest> selectAll();
}