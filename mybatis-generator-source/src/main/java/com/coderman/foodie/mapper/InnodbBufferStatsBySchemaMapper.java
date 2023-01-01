package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbBufferStatsBySchema;
import java.util.List;

public interface InnodbBufferStatsBySchemaMapper {
    int insert(InnodbBufferStatsBySchema record);

    List<InnodbBufferStatsBySchema> selectAll();
}