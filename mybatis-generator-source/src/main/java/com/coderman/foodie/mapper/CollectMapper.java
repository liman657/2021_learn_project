package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Collect;
import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectAll();

    int updateByPrimaryKey(Collect record);
}