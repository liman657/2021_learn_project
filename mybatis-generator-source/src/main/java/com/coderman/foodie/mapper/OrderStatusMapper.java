package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.OrderStatus;
import java.util.List;

public interface OrderStatusMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderStatus record);

    OrderStatus selectByPrimaryKey(String orderId);

    List<OrderStatus> selectAll();

    int updateByPrimaryKey(OrderStatus record);
}