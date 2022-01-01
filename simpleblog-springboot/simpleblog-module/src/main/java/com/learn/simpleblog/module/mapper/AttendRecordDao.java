package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.simpleblog.module.domain.AttendRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttendRecordDao extends BaseMapper<AttendRecordEntity> {

    List<AttendRecordEntity> queryPage(IPage<AttendRecordEntity> page, @Param("paramMap") Map<String, Object> paramMap);

    List<AttendRecordEntity> selectExportData(Map<String, Object> params);

    List<AttendRecordEntity> queryPageSqlServer(Map<String, Object> params);

}
























