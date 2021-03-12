package com.learn.redisson.module.mapper;

import com.learn.redisson.module.entity.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    int unactiveProblem(@Param("id") Integer id);

    Set<Problem> selectAll();
}