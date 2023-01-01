package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Items;
import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Items record);

    Items selectByPrimaryKey(String id);

    List<Items> selectAll();

    int updateByPrimaryKey(Items record);
}