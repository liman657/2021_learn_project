package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationAsynchronousConnectionFailover;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplicationAsynchronousConnectionFailoverMapper {
    int deleteByPrimaryKey(@Param("channelName") String channelName, @Param("host") String host, @Param("port") Integer port, @Param("networkNamespace") String networkNamespace, @Param("managedName") String managedName);

    int insert(ReplicationAsynchronousConnectionFailover record);

    ReplicationAsynchronousConnectionFailover selectByPrimaryKey(@Param("channelName") String channelName, @Param("host") String host, @Param("port") Integer port, @Param("networkNamespace") String networkNamespace, @Param("managedName") String managedName);

    List<ReplicationAsynchronousConnectionFailover> selectAll();

    int updateByPrimaryKey(ReplicationAsynchronousConnectionFailover record);
}