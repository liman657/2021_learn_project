package com.learn.sample.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/8/17
 * comment:
 */
@Data
@ToString
public class SampleMapParamDTO {

    private String testResult;

    private Map<String,Object> extentionParam;

}
