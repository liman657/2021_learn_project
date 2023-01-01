package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XPsDigest95thPercentileByAvgUs;
import java.util.List;

public interface XPsDigest95thPercentileByAvgUsMapper {
    int insert(XPsDigest95thPercentileByAvgUs record);

    List<XPsDigest95thPercentileByAvgUs> selectAll();
}