package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Users;
import java.util.List;

public interface UsersMapper {
    int insert(Users record);

    List<Users> selectAll();
}