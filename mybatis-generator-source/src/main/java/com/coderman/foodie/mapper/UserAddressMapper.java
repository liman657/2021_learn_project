package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserAddress;
import java.util.List;

public interface UserAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAddress record);

    UserAddress selectByPrimaryKey(String id);

    List<UserAddress> selectAll();

    int updateByPrimaryKey(UserAddress record);
}