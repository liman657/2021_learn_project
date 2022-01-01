package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Concern;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface ConcernMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Concern record);

    int insertSelective(Concern record);

    Concern selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Concern record);

    int updateByPrimaryKey(Concern record);


    int countByConcernBeId(@Param("concernId") Integer concernId, @Param("beConcernId") Integer beConcernId);

    int deleteByConcernBeId(@Param("concernId") Integer concernId, @Param("beConcernId") Integer beConcernId);

    //获取关注我的人，即我的粉丝
    int countFansByUserId(@Param("userId") Integer userId);

    //获取我关注的人，即我的好友圈
    int countConcernsByUserId(@Param("userId") Integer userId);


    Set<Integer> selectMyConcerns(@Param("userId") Integer userId);
}