package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StUnitsOfMeasure;
import java.util.List;

public interface StUnitsOfMeasureMapper {
    int insert(StUnitsOfMeasure record);

    List<StUnitsOfMeasure> selectAll();
}