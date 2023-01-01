package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ItemsComments;
import java.util.List;

public interface ItemsCommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemsComments record);

    ItemsComments selectByPrimaryKey(String id);

    List<ItemsComments> selectAll();

    int updateByPrimaryKey(ItemsComments record);
}