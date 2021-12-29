package com.learn.simpleblog.service.web;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:
 */
public interface IIndexCenterService {

    /**
     * 获取博客列表数据
     * @param paramMap
     * @return
     * @throws Exception
     */
    Map<String,Object> data(Map<String, Object> paramMap) throws Exception;

}
