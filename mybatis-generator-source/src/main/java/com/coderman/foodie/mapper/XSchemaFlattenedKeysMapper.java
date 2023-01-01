package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaFlattenedKeys;
import java.util.List;

public interface XSchemaFlattenedKeysMapper {
    int insert(XSchemaFlattenedKeys record);

    List<XSchemaFlattenedKeys> selectAll();
}