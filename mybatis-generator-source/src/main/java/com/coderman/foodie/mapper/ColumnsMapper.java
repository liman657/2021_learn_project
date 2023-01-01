package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Columns;
import java.util.List;

public interface ColumnsMapper {
    int insert(Columns record);

    List<Columns> selectAll();
}