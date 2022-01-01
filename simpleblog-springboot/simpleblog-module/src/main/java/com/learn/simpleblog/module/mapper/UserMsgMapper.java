package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.UserMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKey(UserMsg record);

    List<UserMsg> selectByModuleUIdIsRead(@Param("moduleCode") String moduleCode, @Param("uId") Integer uId, @Param("isRead") Integer isRead);

    Integer countModuleUIdIsRead(@Param("moduleCode") String moduleCode, @Param("uId") Integer uId, @Param("isRead") Integer isRead);
}