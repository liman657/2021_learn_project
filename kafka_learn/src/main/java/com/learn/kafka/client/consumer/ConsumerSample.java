package com.learn.kafka.client.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: consumer简单实例
 */
@Slf4j
public class ConsumerSample {

    public final static String TOPIC_NAME = "client_hello_topic";
    public final static String LOCAL_KAFKA_ADDRESS = "127.0.0.1:9092";

    public static void main(String[] args) {
//        helloworld();
//        commitedOffset();
//        commitOffsetInPartition();
//        commitOffsetPartitionUpdate();
//        controlOffsetPosition();
        consumerLimitStream();
    }


    /**
     * 简单的helloworld，但是这里没有考虑消费失败的情况，如果消费失败，offset并不会重置
     */
    private static void helloworld(){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);//地址
        props.setProperty("group.id", "test");//设置consumer的组
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");//拉取时间间隔
        //key value的序列化
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer(props);
        // 消费订阅哪一个Topic或者几个Topic
        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                        record.partition(),record.offset(), record.key(), record.value());
        }
    }

    /**
     * 手动提交offset，如果消费失败，可以不调用commitAsync()。则下次消费的时候，可以依旧消费未提交的消息
     */
    private static void commitedOffset() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        // 消费订阅哪一个Topic或者几个Topic
        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records) {
                // 想把数据保存到数据库，成功就成功，不成功...
                // TODO record 2 db
                System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                        record.partition(), record.offset(), record.key(), record.value());
                // 如果失败，则回滚， 不要提交offset
            }

            // 如果成功，手动通知offset提交
            consumer.commitAsync();
        }
    }

    /**
     * 以partition为单位进行消息确认提交
     */
    public static void commitOffsetInPartition(){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);

        //消费订阅一个topic或者多个topic
        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            // 针对每个partition单独处理
            for(TopicPartition topicPartition:records.partitions()){
                List<ConsumerRecord<String, String>> partitionRecord = records.records(topicPartition);
                for(ConsumerRecord<String,String> record:partitionRecord){
                    System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                            record.partition(), record.offset(), record.key(), record.value());
                }
                long lastOffset = partitionRecord.get(partitionRecord.size()-1).offset();

                //单个partition中的offset,并且提交
                Map<TopicPartition,OffsetAndMetadata> offsetAndMetadata = new HashMap<>();

                //这里需要注意下，服务器记录的offset是我们下次消费的起点，因此要加一
                offsetAndMetadata.put(topicPartition,new OffsetAndMetadata(lastOffset+1));
                //提交offset
                consumer.commitSync(offsetAndMetadata);
                System.out.println("=============partition - "+ topicPartition +" end================");
            }
        }
    }

    /**
     * 只定于某个一topic下的某一个partition的消息
     * 手动订阅某个或某些分区，并手动提交
     */
    public static void commitOffsetPartitionUpdate(){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        TopicPartition topicPartitionZero = new TopicPartition(TOPIC_NAME,0);
        TopicPartition topicPartitionOne = new TopicPartition(TOPIC_NAME,1);

//        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        //消费订阅一个topic中的一个或者多个partition，这里只定义了一个partition
        consumer.assign(Arrays.asList(topicPartitionOne));
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            // 针对每个partition单独处理
            for(TopicPartition topicPartition:records.partitions()){
                List<ConsumerRecord<String, String>> partitionRecord = records.records(topicPartition);
                for(ConsumerRecord<String,String> record:partitionRecord){
                    System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                            record.partition(), record.offset(), record.key(), record.value());
                }
                long lastOffset = partitionRecord.get(partitionRecord.size()-1).offset();

                //单个partition中的offset,并且提交
                Map<TopicPartition,OffsetAndMetadata> offsetAndMetadata = new HashMap<>();

                //这里需要注意下，服务器记录的offset是我们下次消费的起点，因此要加一
                offsetAndMetadata.put(topicPartition,new OffsetAndMetadata(lastOffset+1));
                //提交offset
                consumer.commitSync(offsetAndMetadata);
                System.out.println("=============partition - "+ topicPartition +" end================");
            }
        }
    }

    /**
     * 手动控制offset
     */
    public static void controlOffsetPosition(){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
//        TopicPartition topicPartitionZero = new TopicPartition(TOPIC_NAME,0);
        TopicPartition topicPartitionOne = new TopicPartition(TOPIC_NAME,1);

//        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        //消费订阅一个topic中的一个或者多个partition，这里只定义了一个partition
        consumer.assign(Arrays.asList(topicPartitionOne));
        while(true){
            /**
             * 实际操作中是：
             * 1、第一次从0开始消费消息
             * 2、比如一次消费了100条，将offset置为101，将该offset数据存入Redis
             * 3、每次poll之前，从Redis中获取最新的offset的位置
             * 4、每次从这个位置开始消费
             * 主要有两种场景：1、人为控制offset起始位置，2、如果出现程序错误，需要重复消费，则手动控制offset位置重复消费一次
             */

            //手动指定offset的起始位置
            consumer.seek(topicPartitionOne,100);
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            // 针对每个partition单独处理
            for(TopicPartition topicPartition:records.partitions()){
                List<ConsumerRecord<String, String>> partitionRecord = records.records(topicPartition);
                for(ConsumerRecord<String,String> record:partitionRecord){
                    System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                            record.partition(), record.offset(), record.key(), record.value());
                }
                long lastOffset = partitionRecord.get(partitionRecord.size()-1).offset();

                //单个partition中的offset,并且提交
                Map<TopicPartition,OffsetAndMetadata> offsetAndMetadata = new HashMap<>();

                //这里需要注意下，服务器记录的offset是我们下次消费的起点，因此要加一
                offsetAndMetadata.put(topicPartition,new OffsetAndMetadata(lastOffset+1));
                //提交offset
                consumer.commitSync(offsetAndMetadata);
                System.out.println("=============partition - "+ topicPartition +" end================");
            }
        }
    }

    /**
     * kafka consumer 限流
     */
    public static void consumerLimitStream(){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        TopicPartition topicPartitionZero = new TopicPartition(TOPIC_NAME,0);
        TopicPartition topicPartitionOne = new TopicPartition(TOPIC_NAME,1);

        //消费订阅一个topic中的一个或者多个partition，这里只定义了一个partition
        consumer.assign(Arrays.asList(topicPartitionZero,topicPartitionOne));
        long totalNum =40l;//阈值，超过这个进行限流
        while(true){

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            // 针对每个partition单独处理
            for(TopicPartition topicPartition:records.partitions()){
                long num = 0l;
                List<ConsumerRecord<String, String>> partitionRecord = records.records(topicPartition);
                for(ConsumerRecord<String,String> record:partitionRecord){
                    System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                            record.partition(), record.offset(), record.key(), record.value());

                    /**
                     * 实际开发中的操作
                     * 1、接收到record信息以后，去令牌桶中拿取令牌
                     * 2、如果获取到令牌，则继续业务处理
                     * 3、如果获取不到令牌， 则pause等待令牌
                     * 4、当令牌桶中的令牌足够， 则将consumer置为resume状态
                     */

                    num++;
                    if(record.partition() == 0){
                        if(num >= totalNum){
                            log.info("暂停partition 0");
                            consumer.pause(Arrays.asList(topicPartitionZero));
                        }
                    }

                    if(record.partition() == 1){
                        if(num == totalNum){
                            log.info("唤醒partition 0");
                            consumer.resume(Arrays.asList(topicPartitionZero));
                        }
                    }

                }
                long lastOffset = partitionRecord.get(partitionRecord.size()-1).offset();

                //单个partition中的offset,并且提交
                Map<TopicPartition,OffsetAndMetadata> offsetAndMetadata = new HashMap<>();

                //这里需要注意下，服务器记录的offset是我们下次消费的起点，因此要加一
                offsetAndMetadata.put(topicPartition,new OffsetAndMetadata(lastOffset+1));
                //提交offset
                consumer.commitSync(offsetAndMetadata);
                num--;
                System.out.println("=============partition - "+ topicPartition +" end================");
            }
        }
    }


}
