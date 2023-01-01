package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummaryByFileIo;
import java.util.List;

public interface HostSummaryByFileIoMapper {
    int insert(HostSummaryByFileIo record);

    List<HostSummaryByFileIo> selectAll();
}