package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Partitions;
import java.util.List;

public interface PartitionsMapper {
    int insert(Partitions record);

    List<Partitions> selectAll();
}