package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ProxiesPriv;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProxiesPrivMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("proxiedHost") String proxiedHost, @Param("proxiedUser") String proxiedUser);

    int insert(ProxiesPriv record);

    ProxiesPriv selectByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("proxiedHost") String proxiedHost, @Param("proxiedUser") String proxiedUser);

    List<ProxiesPriv> selectAll();

    int updateByPrimaryKey(ProxiesPriv record);
}