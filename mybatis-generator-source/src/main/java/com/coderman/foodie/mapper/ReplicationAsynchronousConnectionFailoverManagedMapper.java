package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationAsynchronousConnectionFailoverManaged;
import java.util.List;

public interface ReplicationAsynchronousConnectionFailoverManagedMapper {
    int insert(ReplicationAsynchronousConnectionFailoverManaged record);

    List<ReplicationAsynchronousConnectionFailoverManaged> selectAll();
}