package com.learn.springsourcedemo.service.solo;

import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.dto.Result;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/22
 * comment:头条的方法
 */
public interface IHeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    /**
     * 根据id查询头条信息
     * @param headLineId
     * @return
     */
    Result<HeadLine> queryHeadLineById(int headLineId);

    /**
     * 查询头条列表
     * @param headLineCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,int pageIndex,int pageSize);
}
