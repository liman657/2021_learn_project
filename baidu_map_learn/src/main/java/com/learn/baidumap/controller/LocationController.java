package com.learn.baidumap.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learn.baidumap.api.vo.CityInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/8/16
 * comment:百度地图的controller
 */
@RestController
@Slf4j
@RequestMapping("/pos")
public class LocationController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String baidu_getLoc_url = "https://api.map.baidu.com/reverse_geocoding/v3/?ak=${ak}&output=json&coordtype=wgs84ll";

    /**
     * 根据经纬度获取地理信息
     * @param lnt 经度
     * @param lat 纬度
     * &location=31.225696563611,121.49884033194
     *
     */
    @GetMapping("/loc")
    public CityInfoVO getLocationInfo(String lat,String lnt){
        String finalUrl = baidu_getLoc_url.replace("${ak}","xGGtsvcmqzMKZpXzp7p5n6IjYADvzRZj");
        String locatParam = "&location="+lat+","+lnt;
        finalUrl += locatParam;
        String result = restTemplate.getForObject(finalUrl, String.class);
        log.info("百度地图接口返回的结果为:{}",result);
        //Gson gson = new Gson();
        JsonObject allResultJsonObj = new JsonParser().parse(result).getAsJsonObject();
        JsonObject resultJsonObj = allResultJsonObj.get("result").getAsJsonObject();
        JsonObject addressComponent = resultJsonObj.get("addressComponent").getAsJsonObject();
        JsonObject location = resultJsonObj.get("location").getAsJsonObject();
        CityInfoVO cityInfoVO = new CityInfoVO();
        cityInfoVO.setCity(addressComponent.get("city").getAsString());
        cityInfoVO.setProvince(addressComponent.get("province").getAsString());
        cityInfoVO.setCountry(addressComponent.get("country").getAsString());
        cityInfoVO.setLat(location.get("lat").getAsString());
        cityInfoVO.setLng(location.get("lng").getAsString());
        //cityInfoVO.setCity(addressComponent.get());

        log.info("转换成jsonObj之后的结果为:{}",resultJsonObj);

        log.info("准备返回的结果:{}",cityInfoVO);
        return cityInfoVO;

    }

}
