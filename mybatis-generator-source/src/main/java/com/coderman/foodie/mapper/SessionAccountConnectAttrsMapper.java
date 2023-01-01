package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SessionAccountConnectAttrs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SessionAccountConnectAttrsMapper {
    int deleteByPrimaryKey(@Param("processlistId") Long processlistId, @Param("attrName") String attrName);

    int insert(SessionAccountConnectAttrs record);

    SessionAccountConnectAttrs selectByPrimaryKey(@Param("processlistId") Long processlistId, @Param("attrName") String attrName);

    List<SessionAccountConnectAttrs> selectAll();

    int updateByPrimaryKey(SessionAccountConnectAttrs record);
}