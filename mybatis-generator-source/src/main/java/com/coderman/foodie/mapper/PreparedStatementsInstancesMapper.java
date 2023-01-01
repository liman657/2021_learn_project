package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.PreparedStatementsInstances;
import java.util.List;

public interface PreparedStatementsInstancesMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(PreparedStatementsInstances record);

    PreparedStatementsInstances selectByPrimaryKey(Long objectInstanceBegin);

    List<PreparedStatementsInstances> selectAll();

    int updateByPrimaryKey(PreparedStatementsInstances record);
}