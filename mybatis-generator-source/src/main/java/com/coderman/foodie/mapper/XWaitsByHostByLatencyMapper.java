package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XWaitsByHostByLatency;
import java.util.List;

public interface XWaitsByHostByLatencyMapper {
    int insert(XWaitsByHostByLatency record);

    List<XWaitsByHostByLatency> selectAll();
}