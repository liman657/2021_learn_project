package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableConstraintsExtensions;
import java.util.List;

public interface TableConstraintsExtensionsMapper {
    int insert(TableConstraintsExtensions record);

    List<TableConstraintsExtensions> selectAll();
}