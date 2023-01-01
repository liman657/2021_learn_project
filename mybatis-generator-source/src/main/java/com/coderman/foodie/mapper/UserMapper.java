package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user);

    int insert(User record);

    User selectByPrimaryKey(@Param("host") String host, @Param("user") String user);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}