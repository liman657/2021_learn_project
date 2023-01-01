package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCachedIndexes;
import java.util.List;

public interface InnodbCachedIndexesMapper {
    int insert(InnodbCachedIndexes record);

    List<InnodbCachedIndexes> selectAll();
}