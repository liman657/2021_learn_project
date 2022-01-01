package com.learn.simpleblog.module.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.simpleblog.module.domain.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

//系统日志
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

    void truncate();

}
