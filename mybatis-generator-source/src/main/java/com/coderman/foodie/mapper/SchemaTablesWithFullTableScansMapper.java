package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaTablesWithFullTableScans;
import java.util.List;

public interface SchemaTablesWithFullTableScansMapper {
    int insert(SchemaTablesWithFullTableScans record);

    List<SchemaTablesWithFullTableScans> selectAll();
}