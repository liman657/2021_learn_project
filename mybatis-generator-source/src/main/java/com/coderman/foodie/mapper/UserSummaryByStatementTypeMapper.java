package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummaryByStatementType;
import java.util.List;

public interface UserSummaryByStatementTypeMapper {
    int insert(UserSummaryByStatementType record);

    List<UserSummaryByStatementType> selectAll();
}