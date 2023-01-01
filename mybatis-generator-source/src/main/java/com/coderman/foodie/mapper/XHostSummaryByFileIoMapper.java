package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummaryByFileIo;
import java.util.List;

public interface XHostSummaryByFileIoMapper {
    int insert(XHostSummaryByFileIo record);

    List<XHostSummaryByFileIo> selectAll();
}