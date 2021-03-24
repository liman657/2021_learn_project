package com.learn.redisson.controller.redissonobject;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.Item;
import com.learn.redisson.module.mapper.UserMapper;
import com.learn.redisson.server.IRedissonBloomObjService;
import com.learn.redisson.server.IRedissonTopicObjService;
import com.learn.redisson.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * 布隆过滤器实例
 */
@Slf4j
@RequestMapping("/distobj")
@RestController
public class RedissonBloomObjectController {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private IRedissonBloomObjService redissonBloomObjService;

    /**
     * 添加商品的时候，需要判断商品是否存在，判断存在的过程可以通过bloom过滤器来判断
     * @param item
     * @return
     */
    @RequestMapping(value = "/bloom/simpleDemo",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addItem(@RequestBody @Validated Item item, BindingResult bindingResult) {
        log.info("bloom过滤器实例，开始");
        String res=ValidatorUtil.checkResult(bindingResult);
        if (StringUtils.isNotBlank(res)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),res);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            redissonBloomObjService.addItem(item);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 构造百万数据，利用多线程，插入大量的数据
     */
    @RequestMapping(value = "/bloom/batchData",method = RequestMethod.GET)
    public BaseResponse triggleDataInsert(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        log.info("生成大量商品数据，开始");
        try{
            redissonBloomObjService.genDataByThread();
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 构造百万数据，利用多线程，插入大量的数据
     */
    @RequestMapping(value = "/bloom/isInBigData",method = RequestMethod.GET)
    public BaseResponse isExistInBig(@RequestParam String itemCode){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        log.info("开始判断是否存在于大数据集合中");
        try{
            boolean inBigData = redissonBloomObjService.isInBigData(itemCode);
            response.setData(inBigData);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}