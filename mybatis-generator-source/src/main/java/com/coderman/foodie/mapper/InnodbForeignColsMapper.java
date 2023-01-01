package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbForeignCols;
import java.util.List;

public interface InnodbForeignColsMapper {
    int insert(InnodbForeignCols record);

    List<InnodbForeignCols> selectAll();
}