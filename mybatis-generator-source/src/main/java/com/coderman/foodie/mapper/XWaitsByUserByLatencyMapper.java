package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XWaitsByUserByLatency;
import java.util.List;

public interface XWaitsByUserByLatencyMapper {
    int insert(XWaitsByUserByLatency record);

    List<XWaitsByUserByLatency> selectAll();
}