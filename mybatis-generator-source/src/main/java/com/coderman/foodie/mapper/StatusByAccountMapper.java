package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatusByAccount;
import java.util.List;

public interface StatusByAccountMapper {
    int insert(StatusByAccount record);

    List<StatusByAccount> selectAll();
}