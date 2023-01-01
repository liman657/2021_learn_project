package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementsWithFullTableScans;
import java.util.List;

public interface XStatementsWithFullTableScansMapper {
    int insert(XStatementsWithFullTableScans record);

    List<XStatementsWithFullTableScans> selectAll();
}