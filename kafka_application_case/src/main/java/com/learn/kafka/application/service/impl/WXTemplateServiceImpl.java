package com.learn.kafka.application.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learn.kafka.application.config.WXTemplateProperties;
import com.learn.kafka.application.config.WXTemplateProperties.WXTemplate;
import com.learn.kafka.application.service.IWXTemplateService;
import com.learn.kafka.application.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * autor:liman
 * createtime:2021/3/8
 * comment:
 */
@Service
@Slf4j
public class WXTemplateServiceImpl implements IWXTemplateService {

    @Autowired
    private WXTemplateProperties templateProperties;
    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public WXTemplateProperties.WXTemplate getWXAnswerTemplate() {

        List<WXTemplate> templates = templateProperties.getTemplates();
        Optional<WXTemplate> firstTemplateResult = templates.stream().filter((template) -> template.isActive()).findFirst();
        return firstTemplateResult.isPresent() ? firstTemplateResult.get() : null;
    }


    /***
     * 1、kafka 中的producer是线程安全的，建议多线程复用，如果每个线程都创建，将会出现大量的线程上下文切换，耗费性能
     * 2、Kafka 中的producer的key是一个很重要的内容
     *      2.1 我们可以根据key完成负载均衡
     *      2.2 合理的key设计，可以让flink，Spark Streaming之类的实时分析工具做更快捷的数据分析
     * 3、ack设置为all ,kafka层面上就已经有了只有一次的消息投递保障，但是如果真的不想丢失数据，最好自行处理，将待发送的消息缓存起来
     * @param reportInfo
     */
    @Override
    public void templateAnswerReport(JSONObject reportInfo) {
        log.info("开始上报问卷统计结果:{[这里是测试]}");
        String topic_name = "kafka_application_learn_topic";
        String key = reportInfo.getString("templateId");
        JSONArray value = reportInfo.getJSONArray("result");

        //key相同消息会发送到同一个partition里头，后续统计分析时，可以考虑将相同templteid的内容放入到同一个partition，这样方便统计
        ProducerRecord<String,Object> producerRecord =
                new ProducerRecord<String,Object>(topic_name,key,value);


        //如果对发送结果有要求（比如不能失败等等）
        kafkaProducer.send(producerRecord);

        //如果kafka出现异常，如果需要保证消息不丢失，需要做异常的处理
//        try{
//            kafkaProducer.send(producerRecord);
//        }catch (Exception e){
//            //TODO:这里处理发送消息失败，进入到重复发送消息的缓存机制
//        }
    }

    @Override
    public JSONObject getAnswerStatistics(String templateId) {

        //判断数据结果获取类型
        if(templateProperties.getTemplateResultType() == 0){//文件获取
            return FileUtils.readFile2JsonObject(templateProperties.getTemplateResultFilePath()).get();
        }else{

        }

        return null;
    }
}
