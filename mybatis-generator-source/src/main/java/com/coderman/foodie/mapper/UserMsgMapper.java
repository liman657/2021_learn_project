package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserMsg;
import java.util.List;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    List<UserMsg> selectAll();

    int updateByPrimaryKey(UserMsg record);
}