package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Short customerId);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}