package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummaryByFileIoType;
import java.util.List;

public interface HostSummaryByFileIoTypeMapper {
    int insert(HostSummaryByFileIoType record);

    List<HostSummaryByFileIoType> selectAll();
}