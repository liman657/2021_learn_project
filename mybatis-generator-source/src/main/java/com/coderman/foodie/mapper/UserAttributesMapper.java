package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserAttributes;
import java.util.List;

public interface UserAttributesMapper {
    int insert(UserAttributes record);

    List<UserAttributes> selectAll();
}