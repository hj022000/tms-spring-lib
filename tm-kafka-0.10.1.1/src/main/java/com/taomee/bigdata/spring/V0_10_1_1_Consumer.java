package com.taomee.bigdata.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by looper on 2017/6/8.
 * kafka 消费者
 */
public class V0_10_1_1_Consumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.1.35:9092,10.1.1.151:9093,10.1.1.153:9094");
        props.put("group.id", "test4");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        //props.put("auto.offset.reset","latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
       // props.put();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("v_0_10_1_1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("record the partition = %d, offset = %d, key = %s, value = %s%n", record.partition(),record.offset(), record.key(), record.value());
        }
    }
}
