package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.simpleblog.module.domain.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

//数据字典
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
