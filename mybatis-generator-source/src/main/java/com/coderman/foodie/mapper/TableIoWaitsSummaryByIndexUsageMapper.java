package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableIoWaitsSummaryByIndexUsage;
import java.util.List;

public interface TableIoWaitsSummaryByIndexUsageMapper {
    int insert(TableIoWaitsSummaryByIndexUsage record);

    List<TableIoWaitsSummaryByIndexUsage> selectAll();
}