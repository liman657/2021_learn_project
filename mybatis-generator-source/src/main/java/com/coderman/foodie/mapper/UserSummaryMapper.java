package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummary;
import java.util.List;

public interface UserSummaryMapper {
    int insert(UserSummary record);

    List<UserSummary> selectAll();
}