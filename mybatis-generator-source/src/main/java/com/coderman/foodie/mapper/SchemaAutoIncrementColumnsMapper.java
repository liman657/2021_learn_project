package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaAutoIncrementColumns;
import java.util.List;

public interface SchemaAutoIncrementColumnsMapper {
    int insert(SchemaAutoIncrementColumns record);

    List<SchemaAutoIncrementColumns> selectAll();
}