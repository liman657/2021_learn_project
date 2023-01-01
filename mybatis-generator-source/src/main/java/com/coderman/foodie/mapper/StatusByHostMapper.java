package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatusByHost;
import java.util.List;

public interface StatusByHostMapper {
    int insert(StatusByHost record);

    List<StatusByHost> selectAll();
}