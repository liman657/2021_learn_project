package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XInnodbBufferStatsBySchema;
import java.util.List;

public interface XInnodbBufferStatsBySchemaMapper {
    int insert(XInnodbBufferStatsBySchema record);

    List<XInnodbBufferStatsBySchema> selectAll();
}