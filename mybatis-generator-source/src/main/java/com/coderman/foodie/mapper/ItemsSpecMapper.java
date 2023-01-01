package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ItemsSpec;
import java.util.List;

public interface ItemsSpecMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsSpec record);

    ItemsSpec selectByPrimaryKey(String id);

    List<ItemsSpec> selectAll();

    int updateByPrimaryKey(ItemsSpec record);
}