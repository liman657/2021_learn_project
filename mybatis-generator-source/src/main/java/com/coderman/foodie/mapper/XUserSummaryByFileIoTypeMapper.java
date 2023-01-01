package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummaryByFileIoType;
import java.util.List;

public interface XUserSummaryByFileIoTypeMapper {
    int insert(XUserSummaryByFileIoType record);

    List<XUserSummaryByFileIoType> selectAll();
}