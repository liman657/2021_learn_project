package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementsWithSorting;
import java.util.List;

public interface StatementsWithSortingMapper {
    int insert(StatementsWithSorting record);

    List<StatementsWithSorting> selectAll();
}