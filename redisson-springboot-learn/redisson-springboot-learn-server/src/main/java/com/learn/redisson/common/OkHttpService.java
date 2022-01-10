package com.learn.redisson.common;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * 通用的基于OkHttp3的http服务，发起请求、解析响应工具类
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2020/2/8 15:38
 **/
//@Service
public class OkHttpService {

    private static final Logger log = LoggerFactory.getLogger(OkHttpService.class);

    @Autowired
    private OkHttpClient okHttpClient;


    /**
     * TODO:根据map获取get请求参数 - 查询串 - 如 http://www.fightjava.com/web/index/blog.html?pageNo=2&pageSize=20&search=稳杰
     * @param url - http://www.fightjava.com/web/index/blog.html
     * @param queryMap - map里面就是许多键值对，即key-value ： pageNo=2、pageSize=20、search=稳杰
     * @return 将queryMap里面的键值对元素，转化为查询串：  ?pageNo=2&pageSize=20&search=稳杰
     */
    public StringBuffer getQueryString(final String url, Map<String, String> queryMap) {
        StringBuffer sb = new StringBuffer(url);
        if (queryMap != null && !queryMap.keySet().isEmpty()) {
            Set<String> keys = queryMap.keySet();

            StringBuffer paramMap = new StringBuffer();
            keys.forEach(key -> paramMap.append("&").append(key).append("=").append(queryMap.get(key)));

            sb.append(paramMap.toString().replaceFirst("&", "?"));
        }
        return sb;
    }

    //TODO:调用OKHttp的newCall方法，执行Http请求
    private String execNewCall(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();

            if (response!=null && response.isSuccessful()){
                return response.body().string();
            }
        } catch (Exception e) {
            log.error("调用OKHttp的newCall方法，执行Http请求,发生异常：", e.fillInStackTrace());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    /**
     * TODO:发起Http Get请求
     * @param url 请求url
     * @param queries 请求的参数,即查询串,其中key为参数名，value为对应的取值
     * @return
     */
    public String get(final String url, Map<String, String> queries) {
        StringBuffer sb = getQueryString(url, queries);
        Request request = new Request.Builder()
                .url(sb.toString())
                .build();
        return execNewCall(request);
    }

    /**
     * TODO:发起Http Post请求
     * @param url 请求url
     * @param params 请求的参数,即查询串,其中key为参数名，value为对应的取值
     * @return
     */
    public String postFormParams(final String url, Map<String, String> params) {
        //TODO:往form表单塞请求参数
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && !params.keySet().isEmpty()) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        //TODO:构造Request请求实例
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        return execNewCall(request);
    }

    /**
     * TODO:Post请求发送JSON数据
     * @param url 请求url
     * @param jsonParams 如{"name":"zhangsan","password":"123456"}，即Json格式字符串
     * @return
     */
    public String postJsonParams(final String url, String jsonParams) {
        //TODO:创建请求体
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execNewCall(request);
    }

    /**
     * TODO:Post请求发送JSON数据
     * @param url 请求url
     * @param jsonParams 如{"name":"zhangsan","password":"123456"}，即Json格式字符串
     * @return
     */
    public String postJsonParamsV2(final String url, String jsonParams) {
        //TODO:创建请求体
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execNewCall(request);
    }


    /**
     * TODO:Post请求发送xml数据
     * @param url 请求Url
     * @param xml 请求的xml - String
     * @return
     */
    public String postXmlParams(final String url, String xml) {
        //TODO:创建请求体
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execNewCall(request);
    }

}












