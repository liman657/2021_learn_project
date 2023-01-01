package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationGroupMemberActions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplicationGroupMemberActionsMapper {
    int deleteByPrimaryKey(@Param("name") String name, @Param("event") String event);

    int insert(ReplicationGroupMemberActions record);

    ReplicationGroupMemberActions selectByPrimaryKey(@Param("name") String name, @Param("event") String event);

    List<ReplicationGroupMemberActions> selectAll();

    int updateByPrimaryKey(ReplicationGroupMemberActions record);
}