package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.DataLocks;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataLocksMapper {
    int deleteByPrimaryKey(@Param("engineLockId") String engineLockId, @Param("engine") String engine);

    int insert(DataLocks record);

    DataLocks selectByPrimaryKey(@Param("engineLockId") String engineLockId, @Param("engine") String engine);

    List<DataLocks> selectAll();

    int updateByPrimaryKey(DataLocks record);
}