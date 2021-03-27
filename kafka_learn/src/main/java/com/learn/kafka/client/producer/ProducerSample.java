package com.learn.kafka.client.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * autor:liman
 * createtime:2021/3/7
 * comment: 简单的Producer实例
 */
@Slf4j
public class ProducerSample {

    public final static String TOPIC_NAME = "client_hello_topic";
    public final static String LOCAL_KAFKA_ADDRESS = "127.0.0.1:9092";
    public final static String LINUX_KAFKA_ADDRESS = "192.168.0.110:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        producerAsyncSend();
//        producerSyncSend();
//        producerSendWithCallBack();
        producerSendWithCallBackAndPartition();
    }

    /**
     * 5-2 Producer 异步发送实例
     */
    public static void producerAsyncSend(){
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,LOCAL_KAFKA_ADDRESS);
        properties.put(ProducerConfig.ACKS_CONFIG,"all");//producer发出消息的确认模式
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        //producer的主体
        Producer<String,String> producer = new KafkaProducer<>(properties);

        for(int i = 0;i<10;i++){
            ProducerRecord<String,String> msgRecord = new ProducerRecord<>(TOPIC_NAME,"msgKey-"+i,"msgValue-"+i);
            producer.send(msgRecord);
        }
        //关闭所有的通道
        producer.close();
    }

    /**
     * 5-3 Producer 异步阻塞发送
     */
    public static void producerSyncSend() throws ExecutionException, InterruptedException {
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,LOCAL_KAFKA_ADDRESS);
        properties.put(ProducerConfig.ACKS_CONFIG,"all");//producer发出消息的确认模式
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        //producer的主体
        Producer<String,String> producer = new KafkaProducer<>(properties);

        for(int i = 0;i<10;i++){
            String keyStr = "msgKey-"+i;
            ProducerRecord<String,String> msgRecord = new ProducerRecord<>(TOPIC_NAME,"msgKey-"+i,"msgValue-"+i);
            producer.send(msgRecord);

            Future<RecordMetadata> send = producer.send(msgRecord);
            RecordMetadata recordMetadata = send.get();
            System.out.println(keyStr + "partition : "+recordMetadata.partition()+" , offset : "+recordMetadata.offset());
        }
        //关闭所有的通道
        producer.close();
    }

    /**
     * 5-4 带有回调函数的发送
     */
    public static void producerSendWithCallBack(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,LOCAL_KAFKA_ADDRESS);
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        // Producer的主对象
        Producer<String,String> producer = new KafkaProducer<>(properties);

        // 消息对象 - ProducerRecoder
        for(int i=0;i<10;i++){
            ProducerRecord<String,String> record =
                    new ProducerRecord<>(TOPIC_NAME,"key-"+i,"value-"+i);

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println(
                            "partition : "+recordMetadata.partition()+" , offset : "+recordMetadata.offset());
                }
            });
        }

        // 所有的通道打开都需要关闭
        producer.close();
    }

    /**
     * 5-7 Producer 自定义 partition 负载均衡
     */
    public static void producerSendWithCallBackAndPartition(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,LOCAL_KAFKA_ADDRESS);
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");//重试次数
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");//批次大小
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");//多长时间发送一个批次
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");//缓存大小

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");//key的序列化
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");//value的序列化
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.learn.kafka.client.producer.SelfPartition");//自定义的分区器

        // Producer的主对象
        Producer<String,String> producer = new KafkaProducer<>(properties);

        // 消息对象 - ProducerRecoder
        for(int i=0;i<1000;i++){
            ProducerRecord<String,String> record =
                    new ProducerRecord<>(TOPIC_NAME,"key-"+i,"value-"+i);

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println(
                            "partition : "+recordMetadata.partition()+" , offset : "+recordMetadata.offset());
                }
            });
        }

        // 所有的通道打开都需要关闭
        producer.close();
    }



}
