package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementsWithTempTables;
import java.util.List;

public interface XStatementsWithTempTablesMapper {
    int insert(XStatementsWithTempTables record);

    List<XStatementsWithTempTables> selectAll();
}