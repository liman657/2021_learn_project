package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.LatestFileIo;
import java.util.List;

public interface LatestFileIoMapper {
    int insert(LatestFileIo record);

    List<LatestFileIo> selectAll();
}