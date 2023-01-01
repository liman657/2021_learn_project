package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaTablesWithFullTableScans;
import java.util.List;

public interface XSchemaTablesWithFullTableScansMapper {
    int insert(XSchemaTablesWithFullTableScans record);

    List<XSchemaTablesWithFullTableScans> selectAll();
}