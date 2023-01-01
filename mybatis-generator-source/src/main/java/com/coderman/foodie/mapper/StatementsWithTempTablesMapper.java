package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementsWithTempTables;
import java.util.List;

public interface StatementsWithTempTablesMapper {
    int insert(StatementsWithTempTables record);

    List<StatementsWithTempTables> selectAll();
}