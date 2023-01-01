package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaUnusedIndexes;
import java.util.List;

public interface SchemaUnusedIndexesMapper {
    int insert(SchemaUnusedIndexes record);

    List<SchemaUnusedIndexes> selectAll();
}