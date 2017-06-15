package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/7.
 */
import java.util.*;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class TestProducer {
    public static void main(String[] args) {
        long events = Long.parseLong(args[0]);
        Random rnd = new Random();

        Properties props = new Properties();
       //props.put("metadata.broker.list", "broker1:9092,broker2:9092 ");
        props.put("metadata.broker.list", "10.1.1.228:9092,10.1.1.225:9092,10.1.1.223:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "com.taomee.bigdata.spring.SimplePartitioner");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);

        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("ip-input2", ip, msg);
            producer.send(data);
        }
        producer.close();
    }
}
