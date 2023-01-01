package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Keywords;
import java.util.List;

public interface KeywordsMapper {
    int insert(Keywords record);

    List<Keywords> selectAll();
}