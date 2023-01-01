package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Accounts;
import java.util.List;

public interface AccountsMapper {
    int insert(Accounts record);

    List<Accounts> selectAll();
}