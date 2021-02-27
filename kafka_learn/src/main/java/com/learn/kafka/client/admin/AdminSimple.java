package com.learn.kafka.client.admin;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.internals.Topic;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * autor:liman
 * createtime:2021/2/27
 * comment: admin client的简单实例
 */
@Slf4j
public class AdminSimple {

    public final static String TOPIC_NAME = "client_hello_topic";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        AdminClient adminClient = AdminSimple.adminClient();
//        log.info("get admin client:{}",adminClient);
//        createTopic();
//        deleteTopics();
//        getTopicList();
//        getTopicDescribeInfo();
//        modifyTopicConfigInfo();
//        getTopicConfigInfo();
        incrPartitioins();
        getTopicDescribeInfo();
    }



    /**
     * 获取adminClient
     * @return
     */
    public static AdminClient adminClient(){
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.0.110:9092");

        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }

    public static void createTopic() throws ExecutionException, InterruptedException {
        AdminClient adminClient = AdminSimple.adminClient();
        //副本个数
        Short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME,1,rs);
        CreateTopicsResult topicsResult = adminClient.createTopics(Arrays.asList(newTopic));//返回topic的集合
        topicsResult.all().get();
        log.info("创建topic之后的集合为:{}");
    }

    /**
     * 查看topic列表
     */
    public static void getTopicList() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> topicNames = listTopicsResult.names().get();
        log.info("topic names:{}",topicNames);

        //查看Internal的topic（内部使用的topic）
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);
        ListTopicsResult optionsTopicResult = adminClient.listTopics(options);
        Collection<TopicListing> internalTopicList = optionsTopicResult.listings().get();
        log.info("internal Topic info:{}",internalTopicList);
    }

    /**
     * 删除topics
     */
    public static void deleteTopics() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList(TOPIC_NAME));
//        deleteTopicsResult.all().get();
    }

    /**
     * 查看topic的描述信息
     */
    public static void getTopicDescribeInfo() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Arrays.asList(TOPIC_NAME));
        Map<String, TopicDescription> stringTopicDescriptionMap = describeTopicsResult.all().get();
        log.info("topic 的描述信息:{}",stringTopicDescriptionMap);
    }


    /**
     * 获取topic的配置信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void getTopicConfigInfo() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC,TOPIC_NAME);
        DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(Arrays.asList(configResource));
        Map<ConfigResource, Config> configResourceConfigMap = describeConfigsResult.all().get();
        log.info("topic 的配置信息:{}",configResourceConfigMap);
    }

    /**
     * 修改配置信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void modifyTopicConfigInfo() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        Map<ConfigResource,Config> configMaps = new HashMap<>();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC,TOPIC_NAME);
        Config config = new Config(Arrays.asList(new ConfigEntry("preallocate","true")));
        configMaps.put(configResource,config);
        AlterConfigsResult alterConfigsResult = adminClient.alterConfigs(configMaps);
        alterConfigsResult.all().get();
    }

    /**
     * 增加partition,partition只能增加
     */
    public static void incrPartitioins() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        Map<String,NewPartitions> partitionsMap = new HashMap<>();
        NewPartitions newPartitions = NewPartitions.increaseTo(2);
        partitionsMap.put(TOPIC_NAME,newPartitions);
        CreatePartitionsResult createPartitionsResult = adminClient.createPartitions(partitionsMap);
        createPartitionsResult.all().get();
    }


}
