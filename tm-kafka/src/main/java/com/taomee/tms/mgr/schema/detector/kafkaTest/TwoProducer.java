package com.taomee.tms.mgr.schema.detector.kafkaTest;

import kafka.javaapi.producer.*;
//import kafka.javaapi.producer.Producer;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * Created by looper on 2017/6/6.
 */
public class TwoProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.1.228:9092,10.1.1.225:9092,10.1.1.223:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

      //  Producer<String, String> producer = new KafkaProducer<>(props);
     //   kafka.javaapi.producer.Producer<String ,String> producer = new Ka
       /* for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));

        producer.close();*/
        //Producerproducer = new KafkaProducer<>(props);
        org.apache.kafka.clients.producer.Producer<String,String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0 ; i<100; i++)
        {
            producer.send(new ProducerRecord<String, String>("my-topic2",Integer.toString(i),Integer.toString(i)));
        }
        producer.close();

    }
}
