package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcUser;
import java.util.List;

public interface ImcUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(ImcUser record);

    ImcUser selectByPrimaryKey(Integer userId);

    List<ImcUser> selectAll();

    int updateByPrimaryKey(ImcUser record);
}