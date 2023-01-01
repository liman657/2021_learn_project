package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.BinaryLogTransactionCompressionStats;
import java.util.List;

public interface BinaryLogTransactionCompressionStatsMapper {
    int insert(BinaryLogTransactionCompressionStats record);

    List<BinaryLogTransactionCompressionStats> selectAll();
}