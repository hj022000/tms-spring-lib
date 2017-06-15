package com.taomee.bigdata.spring;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by looper on 2017/6/8.
 * kafka 生产者
 */
public class V0_10_1_1_Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.1.35:9092,10.1.1.151:9093,10.1.1.153:9094");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("v_0_10_1_1", Integer.toString(i), Integer.toString(i)));

        producer.close();
    }
}
