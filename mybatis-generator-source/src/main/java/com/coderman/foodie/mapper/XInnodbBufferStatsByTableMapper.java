package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XInnodbBufferStatsByTable;
import java.util.List;

public interface XInnodbBufferStatsByTableMapper {
    int insert(XInnodbBufferStatsByTable record);

    List<XInnodbBufferStatsByTable> selectAll();
}