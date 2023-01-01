package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummaryByFileIo;
import java.util.List;

public interface XUserSummaryByFileIoMapper {
    int insert(XUserSummaryByFileIo record);

    List<XUserSummaryByFileIo> selectAll();
}