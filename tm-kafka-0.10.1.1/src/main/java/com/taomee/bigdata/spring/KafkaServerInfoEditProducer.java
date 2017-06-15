package com.taomee.bigdata.spring;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by looper on 2017/6/8.
 */
public class KafkaServerInfoEditProducer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaServerInfoEditProducer.class);
    private final String topic;
    private  Producer<String, String> producer;


    /**
     * 构造函数初始化kafka配置信息
     *
     * @param topic
     * @param brokers
     * @param clientId
     */
    public KafkaServerInfoEditProducer(String topic, String brokers, String clientId) {

        InputStream inputStream = null;
        try {
            inputStream = KafkaServerInfoEditProducer.class.getClassLoader().getResourceAsStream("./com/taomee/bigdata/spring/kafka-producer-config.properties");
           // System.out.println(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (brokers != null) {
            props.put("bootstrap.servers", brokers);
        }
        if (clientId != null) {
            props.put("client.id", clientId);
        }
        producer = new KafkaProducer<>(props);
        //new kafka.server.KafkaConfig();
        System.out.println(props.getProperty("value.serializer"));
        this.topic = topic;
    }
    //  public

    /**
     * 发送数据到kafka
     * @param key  serverId
     * @param message 日志信息
     * @return
     */
    public boolean sendMessage(String key,String message)
    {

        try {
            producer.send(new ProducerRecord<String, String>(topic,key,message));
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("发送数据失败!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        for(int i =0 ;i<10;i++) {
            new KafkaServerInfoEditProducer("hj2", null, "looper-looper-id").sendMessage("3", "serverId = 3");
        }
        System.out.println("发送消息结束");

    }

}
