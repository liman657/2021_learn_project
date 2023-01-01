package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.PasswordHistory;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PasswordHistoryMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("passwordTimestamp") Date passwordTimestamp);

    int insert(PasswordHistory record);

    PasswordHistory selectByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("passwordTimestamp") Date passwordTimestamp);

    List<PasswordHistory> selectAll();

    int updateByPrimaryKey(PasswordHistory record);
}