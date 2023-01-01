package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.GeneralLog;
import java.util.List;

public interface GeneralLogMapper {
    int insert(GeneralLog record);

    List<GeneralLog> selectAll();
}