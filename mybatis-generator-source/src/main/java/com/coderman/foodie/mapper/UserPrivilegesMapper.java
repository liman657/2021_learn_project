package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserPrivileges;
import java.util.List;

public interface UserPrivilegesMapper {
    int insert(UserPrivileges record);

    List<UserPrivileges> selectAll();
}