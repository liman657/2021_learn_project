package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.AttendRecord;

import java.util.List;

public interface AttendRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendRecord record);

    AttendRecord selectByPrimaryKey(Integer id);

    List<AttendRecord> selectAll();

    int updateByPrimaryKey(AttendRecord record);
}