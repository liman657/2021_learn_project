package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Collations;
import java.util.List;

public interface CollationsMapper {
    int insert(Collations record);

    List<Collations> selectAll();
}