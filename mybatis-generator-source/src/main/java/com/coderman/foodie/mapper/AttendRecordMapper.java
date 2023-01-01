package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.AttendRecord;
import java.util.List;

public interface AttendRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendRecord record);

    AttendRecord selectByPrimaryKey(Integer id);

    List<AttendRecord> selectAll();

    int updateByPrimaryKey(AttendRecord record);
}