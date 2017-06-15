package com.taomee.bigdata.spring;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by looper on 2017/6/7.
 */
public class Consumer8 extends Thread {
    private final ConsumerConnector consumer;
    private final String topic;

    public Consumer8(String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig());
        this.topic = topic;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "10.1.1.228:2181,10.1.1.225:2181,10.1.1.223:2181/kafka");
        props.put("group.id", "looper-id");
        props.put("zookeeper.session.timeout.ms", "6000");
        props.put("zookeeper.sync.time.ms", "6000");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }

    @Override
    public void run() {
        // super.run();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> streams = consumerMap.get(topic).get(0);
        /*KafkaStream<byte[], byte[]> streams2 = streams;
        ConsumerIterator<byte[], byte[]> it2 = streams2.iterator();*/
        ConsumerIterator<byte[], byte[]> it = streams.iterator();
       // System.out.println("it2:"+it2);
       // System.out.println("end");
        //System.out.println("it:" +it);
        /*while (it.hasNext()) {
            System.out.println(new String(it.next().message()));
        }*/
        while (it.hasNext())
        {
            System.out.println(new String(it.next().message()));
        }
    }
}
