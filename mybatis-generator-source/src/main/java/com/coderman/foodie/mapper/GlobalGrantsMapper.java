package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.GlobalGrants;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GlobalGrantsMapper {
    int deleteByPrimaryKey(@Param("user") String user, @Param("host") String host, @Param("priv") String priv);

    int insert(GlobalGrants record);

    GlobalGrants selectByPrimaryKey(@Param("user") String user, @Param("host") String host, @Param("priv") String priv);

    List<GlobalGrants> selectAll();

    int updateByPrimaryKey(GlobalGrants record);
}