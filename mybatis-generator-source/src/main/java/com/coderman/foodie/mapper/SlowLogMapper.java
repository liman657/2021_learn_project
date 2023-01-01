package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SlowLog;
import java.util.List;

public interface SlowLogMapper {
    int insert(SlowLog record);

    List<SlowLog> selectAll();
}