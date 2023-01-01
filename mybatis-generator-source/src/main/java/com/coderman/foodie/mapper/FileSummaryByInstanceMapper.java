package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FileSummaryByInstance;
import java.util.List;

public interface FileSummaryByInstanceMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(FileSummaryByInstance record);

    FileSummaryByInstance selectByPrimaryKey(Long objectInstanceBegin);

    List<FileSummaryByInstance> selectAll();

    int updateByPrimaryKey(FileSummaryByInstance record);
}