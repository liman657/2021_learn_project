package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StGeometryColumns;
import java.util.List;

public interface StGeometryColumnsMapper {
    int insert(StGeometryColumns record);

    List<StGeometryColumns> selectAll();
}