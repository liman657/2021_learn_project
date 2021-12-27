package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.UserMsg;

import java.util.List;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    List<UserMsg> selectAll();

    int updateByPrimaryKey(UserMsg record);
}