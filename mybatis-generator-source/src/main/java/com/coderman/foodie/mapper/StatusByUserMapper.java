package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatusByUser;
import java.util.List;

public interface StatusByUserMapper {
    int insert(StatusByUser record);

    List<StatusByUser> selectAll();
}