package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TablesExtensions;
import java.util.List;

public interface TablesExtensionsMapper {
    int insert(TablesExtensions record);

    List<TablesExtensions> selectAll();
}