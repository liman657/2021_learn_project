package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XLatestFileIo;
import java.util.List;

public interface XLatestFileIoMapper {
    int insert(XLatestFileIo record);

    List<XLatestFileIo> selectAll();
}