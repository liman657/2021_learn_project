package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TablespacesExtensions;
import java.util.List;

public interface TablespacesExtensionsMapper {
    int insert(TablespacesExtensions record);

    List<TablespacesExtensions> selectAll();
}