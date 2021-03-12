package com.learn.redisson.module.mapper;

import com.learn.redisson.api.dto.ProductInfo;
import com.learn.redisson.module.entity.ProductKill;
import org.apache.ibatis.annotations.Param;

public interface ProductKillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductKill record);

    int insertSelective(ProductKill record);

    ProductKill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductKill record);

    int updateByPrimaryKey(ProductKill record);

    ProductKill selectByKillId(@Param("killId") Integer killId);

    int updateKillSuccess(@Param("killId") Integer killId);


    ProductKill selectByKillIdV2(@Param("killId") Integer killId);

    int updateKillSuccessV2(@Param("killId") Integer killId);




    ProductInfo selectByKillIdRemote(@Param("killId") Integer killId);

}