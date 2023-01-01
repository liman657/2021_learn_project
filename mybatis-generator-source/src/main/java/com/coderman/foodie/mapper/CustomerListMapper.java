package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.CustomerList;
import java.util.List;

public interface CustomerListMapper {
    int insert(CustomerList record);

    List<CustomerList> selectAll();
}