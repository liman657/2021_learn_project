package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ItemsImg;
import java.util.List;

public interface ItemsImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsImg record);

    ItemsImg selectByPrimaryKey(String id);

    List<ItemsImg> selectAll();

    int updateByPrimaryKey(ItemsImg record);
}