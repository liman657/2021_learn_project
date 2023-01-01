package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementsWithSorting;
import java.util.List;

public interface XStatementsWithSortingMapper {
    int insert(XStatementsWithSorting record);

    List<XStatementsWithSorting> selectAll();
}