package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationGroupMembers;
import java.util.List;

public interface ReplicationGroupMembersMapper {
    int insert(ReplicationGroupMembers record);

    List<ReplicationGroupMembers> selectAll();
}