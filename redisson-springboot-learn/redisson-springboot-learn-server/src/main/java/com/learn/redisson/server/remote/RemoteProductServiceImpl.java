package com.learn.redisson.server.remote;

import com.learn.redisson.api.dto.ProductInfo;
import com.learn.redisson.api.service.IRemoteProductService;
import com.learn.redisson.api.service.RemoteResponse;
import com.learn.redisson.api.service.RemoteStatus;
import com.learn.redisson.module.mapper.ProductKillMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/4/10
 * comment:
 */
@Service("remoteProductService")
@Slf4j
public class RemoteProductServiceImpl implements IRemoteProductService {

    @Autowired
    private ProductKillMapper productKillMapper;

    @Override
    public RemoteResponse getInfo(Integer id) {
        RemoteResponse remoteResponse = new RemoteResponse(RemoteStatus.Success);
        try {
            ProductInfo productInfo = productKillMapper.selectByKillIdRemote(id);
            remoteResponse.setData(productInfo);
        } catch (Exception e) {
            log.info("查询商品详情出现异常，异常信息为：{}", e);
            remoteResponse = new RemoteResponse(RemoteStatus.Fail.getCode(), e.getMessage());
        }
        return remoteResponse;
    }
}
