package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EventsStatementsSummaryByProgram;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventsStatementsSummaryByProgramMapper {
    int deleteByPrimaryKey(@Param("objectType") String objectType, @Param("objectSchema") String objectSchema, @Param("objectName") String objectName);

    int insert(EventsStatementsSummaryByProgram record);

    EventsStatementsSummaryByProgram selectByPrimaryKey(@Param("objectType") String objectType, @Param("objectSchema") String objectSchema, @Param("objectName") String objectName);

    List<EventsStatementsSummaryByProgram> selectAll();

    int updateByPrimaryKey(EventsStatementsSummaryByProgram record);
}