package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.LogStatus;
import java.util.List;

public interface LogStatusMapper {
    int insert(LogStatus record);

    List<LogStatus> selectAll();
}