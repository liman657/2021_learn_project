package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableLockWaitsSummaryByTable;
import java.util.List;

public interface TableLockWaitsSummaryByTableMapper {
    int insert(TableLockWaitsSummaryByTable record);

    List<TableLockWaitsSummaryByTable> selectAll();
}