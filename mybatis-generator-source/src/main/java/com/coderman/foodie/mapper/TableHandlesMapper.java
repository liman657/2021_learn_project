package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableHandles;
import java.util.List;

public interface TableHandlesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(TableHandles record);

    TableHandles selectByPrimaryKey(Long objectInstanceBegin);

    List<TableHandles> selectAll();

    int updateByPrimaryKey(TableHandles record);
}