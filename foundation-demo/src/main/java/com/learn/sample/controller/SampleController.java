package com.learn.sample.controller;

import com.learn.sample.dto.SampleMapParamDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * autor:liman
 * createtime:2021/8/17
 * comment:
 */
@RestController
@Slf4j
@RequestMapping("/sample")
public class SampleController {

    @PostMapping("/mapparam")
    public String mapParamMethod(@RequestBody SampleMapParamDTO sampleMapParamDTO){
        log.info("请求得到的参数为:{}",sampleMapParamDTO);

        String success = "success";
        return success;
    }

}
