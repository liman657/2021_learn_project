package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.OrderItems;
import java.util.List;

public interface OrderItemsMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderItems record);

    OrderItems selectByPrimaryKey(String id);

    List<OrderItems> selectAll();

    int updateByPrimaryKey(OrderItems record);
}