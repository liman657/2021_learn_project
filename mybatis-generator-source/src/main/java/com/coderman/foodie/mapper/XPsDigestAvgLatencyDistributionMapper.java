package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XPsDigestAvgLatencyDistribution;
import java.util.List;

public interface XPsDigestAvgLatencyDistributionMapper {
    int insert(XPsDigestAvgLatencyDistribution record);

    List<XPsDigestAvgLatencyDistribution> selectAll();
}