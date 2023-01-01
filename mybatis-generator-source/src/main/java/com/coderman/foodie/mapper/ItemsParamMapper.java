package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ItemsParam;
import java.util.List;

public interface ItemsParamMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsParam record);

    ItemsParam selectByPrimaryKey(String id);

    List<ItemsParam> selectAll();

    int updateByPrimaryKey(ItemsParam record);
}