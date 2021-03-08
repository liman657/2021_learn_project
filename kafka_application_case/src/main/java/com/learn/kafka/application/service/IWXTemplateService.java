package com.learn.kafka.application.service;
import com.alibaba.fastjson.JSONObject;
import com.learn.kafka.application.config.WXTemplateProperties.WXTemplate;

/**
 * autor:liman
 * createtime:2021/3/8
 * comment:
 */
public interface IWXTemplateService {

    /**
     * 获取目前active为true的答题模板即可
     * @return
     */
    public WXTemplate getWXAnswerTemplate();

    /**
     * 上报答题结果
     * @param reportInfo
     */
    public void templateAnswerReport(JSONObject reportInfo);

    /**
     * 获取相关统计结果
     * @param templateId
     * @return
     */
    public JSONObject getAnswerStatistics(String templateId);

}
