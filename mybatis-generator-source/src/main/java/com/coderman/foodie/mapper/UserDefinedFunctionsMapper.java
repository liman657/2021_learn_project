package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserDefinedFunctions;
import java.util.List;

public interface UserDefinedFunctionsMapper {
    int deleteByPrimaryKey(String udfName);

    int insert(UserDefinedFunctions record);

    UserDefinedFunctions selectByPrimaryKey(String udfName);

    List<UserDefinedFunctions> selectAll();

    int updateByPrimaryKey(UserDefinedFunctions record);
}