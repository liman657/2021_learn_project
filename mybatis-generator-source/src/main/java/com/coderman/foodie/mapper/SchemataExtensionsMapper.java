package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemataExtensions;
import java.util.List;

public interface SchemataExtensionsMapper {
    int insert(SchemataExtensions record);

    List<SchemataExtensions> selectAll();
}