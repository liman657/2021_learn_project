package com.learn.redisson.module.mapper;

import com.learn.redisson.module.entity.MailInfo;
import org.apache.ibatis.annotations.Param;

public interface MailInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MailInfo record);

    int insertSelective(MailInfo record);

    MailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailInfo record);

    int updateByPrimaryKeyWithBLOBs(MailInfo record);

    int updateByPrimaryKey(MailInfo record);

    int invalidateMail(@Param("id") Integer id);

    //String selectEmailById(@Param("id") Integer id);
}