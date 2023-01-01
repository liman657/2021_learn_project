package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbBufferStatsByTable;
import java.util.List;

public interface InnodbBufferStatsByTableMapper {
    int insert(InnodbBufferStatsByTable record);

    List<InnodbBufferStatsByTable> selectAll();
}