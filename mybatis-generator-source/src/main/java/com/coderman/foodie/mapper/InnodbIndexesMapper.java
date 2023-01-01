package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbIndexes;
import java.util.List;

public interface InnodbIndexesMapper {
    int insert(InnodbIndexes record);

    List<InnodbIndexes> selectAll();
}