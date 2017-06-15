package com.taomee.tms.mgr.schema.detector.kafkaTest;

public interface KafkaProperties
{
  final static String zkConnect = "10.1.1.228:2181,10.1.1.225:2181,10.1.1.223:2181";
  final static  String groupId = "looper-consumer-group1";
  final static String topic = "kafka-pcc-input1";
  final static String kafkaServerURL = "10.1.1.228";
  final static int kafkaServerPort = 9092;
  final static int kafkaProducerBufferSize = 64*1024;
  final static int connectionTimeOut = 100000;
  final static int reconnectInterval = 10000;
  final static String topic2 = "topic2";
  final static String topic3 = "topic3";
  final static String clientId = "SimpleConsumerDemoClient";
}
