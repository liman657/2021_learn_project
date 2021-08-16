package com.learn.baidumap.api.vo;

import lombok.Data;
import lombok.ToString;

/**
 * autor:liman
 * createtime:2021/8/16
 * comment:
 */
@Data
@ToString
public class CityInfoVO {

    private String city;//城市
    private String province;//省份
    private String country;//国家

    private String lng;//经度
    private String lat;//纬度

}
