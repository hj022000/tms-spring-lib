package com.taomee.bigdata.spring;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by looper on 2017/6/7.
 */
public class V8_Producer extends Thread{
    private final kafka.javaapi.producer.Producer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public V8_Producer(String topic)
    {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        // Use random partitioner. Don't need the key type. Just set it to Integer.
        // The message is of type String.
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));
        this.topic = topic;
    }

    public void run() {
        int messageNo = 1;
        while(true)
        {
            String messageStr = new String("Message_" + messageNo);
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
            messageNo++;
        }
    }
}
