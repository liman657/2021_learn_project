package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Orders;
import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    Orders selectByPrimaryKey(String id);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}