package com.learn.kafka.client.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: 类似于netty的那种多线程方式，对partition的管控力度没有那么强，但是这种方式比较适用于流处理
 *
 */
@Slf4j
public class ConsumerRecordThreadSample {

    public final static String TOPIC_NAME = "client_hello_topic";
    public final static String LOCAL_KAFKA_ADDRESS = "127.0.0.1:9092";

    public static void main(String[] args) throws InterruptedException {
        String brokerList = LOCAL_KAFKA_ADDRESS;
        String groupId = "test";
        int workNum = 5;

        ConsumerExecutor consumerExecutor = new ConsumerExecutor(brokerList,groupId,TOPIC_NAME);
        consumerExecutor.execute(workNum);

        Thread.sleep(1000000);
        consumerExecutor.shutdown();
    }

    public static class ConsumerExecutor{
        private final KafkaConsumer<String,String> consumer;
        private ExecutorService executors;

        public ConsumerExecutor(String brokerList,String groupId,String topic){
            Properties props = new Properties();
            props.put("bootstrap.servers", brokerList);
            props.put("group.id", groupId);
            props.put("enable.auto.commit", "true");
            props.put("auto.commit.interval.ms", "1000");
            props.put("session.timeout.ms", "30000");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topic));
        }

        public void execute(int workerNum){
            //这里初始化线程池
            executors = new ThreadPoolExecutor(workerNum,workerNum,0L, TimeUnit.MICROSECONDS
                    ,new ArrayBlockingQueue<>(1000),new ThreadPoolExecutor.CallerRunsPolicy());

            while(true){
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(20000));
                for (final ConsumerRecord record : records) {
                    executors.submit(new ConsumerRecordWorker(record));
                }
            }
        }

        public void shutdown() {
            if (consumer != null) {
                consumer.close();
            }
            if (executors != null) {
                executors.shutdown();
            }
            try {
                if (!executors.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.out.println("Timeout.... Ignore for this case");
                }
            } catch (InterruptedException ignored) {
                System.out.println("Other thread interrupted this shutdown, ignore for this case.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class ConsumerRecordWorker implements Runnable{

        private ConsumerRecord<String, String> record;

        public ConsumerRecordWorker(ConsumerRecord record) {
            this.record = record;
        }

        @Override
        public void run() {
            // 假如说数据入库操作
            String threadName="Thread - "+ Thread.currentThread().getName();
            log.error("thread-name:{}",threadName);
            System.out.println();
            System.err.printf("ThreadName = %s ,patition = %d , offset = %d, key = %s, value = %s%n",threadName,
                    record.partition(), record.offset(), record.key(), record.value());
        }
    }

}
