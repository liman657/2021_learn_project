package com.learn.springsourcedemo.service.solo.impl;

import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.dto.Result;
import com.learn.springsourcedemo.service.solo.IHeadLineService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/22
 * comment:
 */
@Slf4j
public class HeadLineServiceImpl implements IHeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
