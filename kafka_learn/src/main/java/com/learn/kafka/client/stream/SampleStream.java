package com.learn.kafka.client.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

/**
 * autor:liman
 * createtime:2021/4/10
 * comment: stream的简单实例
 */
public class SampleStream {

    //用于input数据的stream
    private static final String INPUT_TOPIC = "stream-input-topic";
    //用于output数据的stream
    private static final String OUTPUT_TOPIC = "stream-output-topic";
    public final static String LINUX_KAFKA_ADDRESS = "192.168.0.110:9092";

    /**
     * 正式开始stream的实例，topic通过admin创建
     * @param args
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,LINUX_KAFKA_ADDRESS);
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"stream-workcount-app");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());

        //Stream的构建器
        StreamsBuilder builder = new StreamsBuilder();

        wordCountStream(builder);
        //Stream的实例化，需要将构建器以参数的形式传递进去
        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(),properties);

        kafkaStreams.start();
    }

    /**
     * 流，通过StreamBuilder构造处理数据的流程
     * 简单的wordcount实例
     * @param streamsBuilder
     */
    public static void wordCountStream(final StreamsBuilder streamsBuilder){
        //不断从input-topic中获取数据的流
        KStream<String, String> sourceStream = streamsBuilder.stream(INPUT_TOPIC);//构建source-stream，通过参数告知需要从哪儿读取数据

        KTable<String, Long> result = sourceStream
                // flatMapValues -> 将一行数据拆分为多行数据  key 1 , value Hello World
                // flatMapValues -> 将一行数据拆分为多行数据  key 1 , value Hello key xx , value World
                /*
                    key 1 , value Hello   -> Hello 1  World 2
                    key 2 , value World
                    key 3 , value World
                 */
                .flatMapValues(value -> Arrays.asList(value.toLowerCase(Locale.getDefault()).split(" ")))
                .groupBy((key, value) -> value)
                .count();

        //相当于将输出结果推送到OUT_TOPIC中
        result.toStream().to(OUTPUT_TOPIC, Produced.with(Serdes.String(),Serdes.Long()));
    }

}
