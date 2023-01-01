package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ColumnsExtensions;
import java.util.List;

public interface ColumnsExtensionsMapper {
    int insert(ColumnsExtensions record);

    List<ColumnsExtensions> selectAll();
}