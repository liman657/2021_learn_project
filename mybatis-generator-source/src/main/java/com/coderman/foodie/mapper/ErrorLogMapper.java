package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ErrorLog;
import java.util.Date;
import java.util.List;

public interface ErrorLogMapper {
    int deleteByPrimaryKey(Date logged);

    int insert(ErrorLog record);

    ErrorLog selectByPrimaryKey(Date logged);

    List<ErrorLog> selectAll();

    int updateByPrimaryKey(ErrorLog record);
}