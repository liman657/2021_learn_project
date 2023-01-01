package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementsWithFullTableScans;
import java.util.List;

public interface StatementsWithFullTableScansMapper {
    int insert(StatementsWithFullTableScans record);

    List<StatementsWithFullTableScans> selectAll();
}