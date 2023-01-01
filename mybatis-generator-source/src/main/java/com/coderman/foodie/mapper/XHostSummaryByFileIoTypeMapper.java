package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummaryByFileIoType;
import java.util.List;

public interface XHostSummaryByFileIoTypeMapper {
    int insert(XHostSummaryByFileIoType record);

    List<XHostSummaryByFileIoType> selectAll();
}