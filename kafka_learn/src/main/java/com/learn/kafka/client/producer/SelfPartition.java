package com.learn.kafka.client.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/3/7
 * comment:
 */
@Slf4j
public class SelfPartition implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String keyStr = key+"";
        String keyInt = keyStr.substring(4);
        log.info("keyStr:{},keyInt:{}",keyStr,keyInt);

        int i = Integer.parseInt(keyInt);

        return i%2;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
