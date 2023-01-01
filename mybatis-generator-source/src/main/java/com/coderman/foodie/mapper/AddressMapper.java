package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Short addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Short addressId);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}