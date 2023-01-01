package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableIoWaitsSummaryByTable;
import java.util.List;

public interface TableIoWaitsSummaryByTableMapper {
    int insert(TableIoWaitsSummaryByTable record);

    List<TableIoWaitsSummaryByTable> selectAll();
}