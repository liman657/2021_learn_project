package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TUser;
import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    TUser selectByPrimaryKey(Long id);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser record);
}