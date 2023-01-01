package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaRedundantIndexes;
import java.util.List;

public interface SchemaRedundantIndexesMapper {
    int insert(SchemaRedundantIndexes record);

    List<SchemaRedundantIndexes> selectAll();
}