package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationGroupMemberStats;
import java.util.List;

public interface ReplicationGroupMemberStatsMapper {
    int insert(ReplicationGroupMemberStats record);

    List<ReplicationGroupMemberStats> selectAll();
}