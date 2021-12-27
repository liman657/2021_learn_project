package com.learn.simpleblog.api.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.simpleblog.api.filter.SQLFilter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 查询统一封装的工具类
 * @Author:debug (SteadyJack) - wx:debug0868
 **/
public class QueryUtil<T> {

    /**
     * 根据前端传递过来的参数进行转换 - 过滤
     * @param params
     * @return
     */
    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(Constant.PAGE) != null){
            curPage = Long.parseLong((String)params.get(Constant.PAGE));
        }
        if(params.get(Constant.LIMIT) != null){
            limit = Long.parseLong((String)params.get(Constant.LIMIT));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(Constant.PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject((String)params.get(Constant.ORDER_FIELD));
        String order = (String)params.get(Constant.ORDER);

        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if(Constant.ASC.equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            }else {
                return page.setDesc(orderField);
            }
        }

        //默认排序
        if(isAsc) {
            page.setAsc(defaultOrderField);
        }else {
            page.setDesc(defaultOrderField);
        }

        return page;
    }

    //重载的查询
    public IPage<T> getQueryPage(Map<String, Object> params) {
        //当前第几页、每页显示的条目
        long curPage = 1;
        long limit = 10;

        if (params.get(Constant.PAGE)!=null){
            curPage=Long.valueOf(params.get(Constant.PAGE).toString());
        }
        if (params.get(Constant.LIMIT)!=null){
            limit=Long.valueOf(params.get(Constant.LIMIT).toString());
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //前端请求的字段排序
        if(params.get(Constant.ORDER)!=null && params.get(Constant.ORDER_FIELD)!=null){

            SQLFilter.sqlInject((String) params.get(Constant.ORDER_FIELD));

            if(Constant.ASC.equalsIgnoreCase(params.get(Constant.ORDER).toString())) {
                return page.setAsc(params.get(Constant.ORDER_FIELD).toString());
            }else {
                return page.setDesc(params.get(Constant.ORDER_FIELD).toString());
            }
        }

        return page;
    }
}




























