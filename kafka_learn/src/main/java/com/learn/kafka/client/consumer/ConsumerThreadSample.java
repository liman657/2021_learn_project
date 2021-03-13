package com.learn.kafka.client.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment:consumer 多线程简单实例
 * kafka的consumer不是线程安全的，需要自己解决线程安全的问题
 * 因此我们每个线程中，都实例化了一个KafaConsumer
 */
@Slf4j
public class ConsumerThreadSample {

    public final static String TOPIC_NAME = "client_hello_topic";
    public final static String LOCAL_KAFKA_ADDRESS = "127.0.0.1:9092";


    /**
     * 这种类型是经典模式，是每一个线程单独创建一个KafkaConsumer，用于保证线程安全
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        KafkaConsumerRunner kafkaConsumerRunner = new KafkaConsumerRunner();
        Thread threadOne = new Thread(kafkaConsumerRunner);
        threadOne.start();
        Thread.sleep(15000);

        kafkaConsumerRunner.shutdown();

    }



    public static class KafkaConsumerRunner implements Runnable{

        private final AtomicBoolean closed = new AtomicBoolean(false);
        private final KafkaConsumer consumer;

        public KafkaConsumerRunner() {
            Properties props = new Properties();
            props.put("bootstrap.servers", LOCAL_KAFKA_ADDRESS);
            props.put("group.id", "test");
            props.put("enable.auto.commit", "false");
            props.put("auto.commit.interval.ms", "1000");
            props.put("session.timeout.ms", "30000");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

            consumer = new KafkaConsumer<>(props);

            TopicPartition p0 = new TopicPartition(TOPIC_NAME, 0);
            TopicPartition p1 = new TopicPartition(TOPIC_NAME, 1);

            consumer.assign(Arrays.asList(p0,p1));
        }

        @Override
        public void run() {
            try{
                while(!closed.get()){
                    //处理消息
                    ConsumerRecords<String,String> consumerRecord = consumer.poll(Duration.ofMillis(10000));
                    for(TopicPartition topicPartition:consumerRecord.partitions()){
                        List<ConsumerRecord<String, String>> partitionRecord = consumerRecord.records(topicPartition);
                        //处理每一个分区的数据
                        for(ConsumerRecord<String,String> record:partitionRecord){
                            System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                                    record.partition(),record.offset(), record.key(), record.value());
                        }
                        // 返回去告诉kafka新的offset
                        long lastOffset = partitionRecord.get(partitionRecord.size() - 1).offset();
                        // 注意加1
                        consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(lastOffset + 1)));
                    }
                }
            }catch (WakeupException e){
                if(!closed.get()){
                    throw e;
                }
            }finally {
                consumer.close();
            }
        }

        public void shutdown() {
            closed.set(true);
            consumer.wakeup();
        }
    }
}
