package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SessionConnectAttrs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SessionConnectAttrsMapper {
    int deleteByPrimaryKey(@Param("processlistId") Long processlistId, @Param("attrName") String attrName);

    int insert(SessionConnectAttrs record);

    SessionConnectAttrs selectByPrimaryKey(@Param("processlistId") Long processlistId, @Param("attrName") String attrName);

    List<SessionConnectAttrs> selectAll();

    int updateByPrimaryKey(SessionConnectAttrs record);
}