package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/7.
 */
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConsumerGroupExample2 {
    private final ConsumerConnector consumer;
    private final String topic;
    //private  ExecutorService executor;

    public ConsumerGroupExample2(String a_zookeeper, String a_groupId, String a_topic) {
        System.out.println("zk:"+a_zookeeper +","+"groupId:" +a_groupId+","+"topic:"+a_topic);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig(a_zookeeper, a_groupId));
        this.topic = a_topic;
    }

   /* public void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (executor != null) executor.shutdown();
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }*/

    public void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> streams = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = streams.iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            System.out.println(new String(it.next().message()));
            System.out.println("t...");
            hasNext = it.hasNext();
        }
     //   System.out.println();
       // System.out.println("streams:" +streams);

        // now launch all the threads
     /*   //
        executor = Executors.newFixedThreadPool(a_numThreads);

        // now create an object to consume the messages
        //
        int threadNumber = 0;
        for (final KafkaStream stream : streams) {
         //   System.out.println("stream:"+stream);
            //System.out.println("ThreadNumer:" + threadNumber);
            executor.submit(new ConsumerTest(stream, threadNumber));
            threadNumber++;
        }*/
    }

    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "6000");
        props.put("zookeeper.sync.time.ms", "6000");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }

    public static void main(String[] args) {
        /*String zooKeeper = args[0];
        String groupId = args[1];
        String topic = args[2];
        int threads = Integer.parseInt(args[3]);*/

        String zooKeeper = "10.1.1.228:2181,10.1.1.225:2181,10.1.1.223:2181";
        String groupId = "looper";
        String topic = "ip-input";
        int threads = 4;


        ConsumerGroupExample2 example = new ConsumerGroupExample2(zooKeeper, groupId, topic);
        example.run(threads);
       /* example.run(threads);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {

        }*/
       // example.shutdown();
    }
}