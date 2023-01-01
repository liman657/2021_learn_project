package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaObjectOverview;
import java.util.List;

public interface SchemaObjectOverviewMapper {
    int insert(SchemaObjectOverview record);

    List<SchemaObjectOverview> selectAll();
}