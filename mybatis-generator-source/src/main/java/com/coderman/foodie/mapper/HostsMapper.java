package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Hosts;
import java.util.List;

public interface HostsMapper {
    int insert(Hosts record);

    List<Hosts> selectAll();
}