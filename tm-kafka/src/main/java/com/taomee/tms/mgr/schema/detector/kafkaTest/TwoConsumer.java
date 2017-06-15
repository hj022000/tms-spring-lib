package com.taomee.tms.mgr.schema.detector.kafkaTest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * Created by looper on 2017/6/6.
 */
public class TwoConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.1.228:9092,10.1.1.225:9092,10.1.1.223:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //props.put("partition.assignment.strategy","range");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
       // consumer.subscribe("my-topic2");
       /* consumer.subscribe(Arrays.asList("foo", "bar"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }*/
       /* consumer.subscribe
        while (true)
        {
           // Map<String, ConsumerRecords<String , String>> maps = consumer.poll(100);
            //System.out.println("maps:" + maps);
        }*/
        consumer.subscribe(Arrays.asList("my-topic2"));
        while(true)
        {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
             }
        }
    }
