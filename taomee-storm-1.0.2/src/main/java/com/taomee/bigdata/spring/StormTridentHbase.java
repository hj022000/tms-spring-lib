package com.taomee.bigdata.spring;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.hbase.trident.mapper.SimpleTridentHBaseMapMapper;
import org.apache.storm.hbase.trident.mapper.TridentHBaseMapMapper;
import org.apache.storm.hbase.trident.state.HBaseMapState;

import org.apache.storm.kafka.StringScheme;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.kafka.trident.OpaqueTridentKafkaSpout;
import org.apache.storm.kafka.trident.TridentKafkaConfig;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.trident.Stream;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.testing.FixedBatchSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * create 'wordcount','val'
 * Date  2017/6/26.
 */
public class StormTridentHbase {

    /**
     * Hbase 建表语句:
     * create "wordcount2","val"
     */
    static final String TOPIC_NAME = "wordcount2hbase";
    static final String zkHosts = "10.1.1.35:2181,10.1.1.153:2181,10.1.1.151:2181";

    public static StormTopology buildTopology() {

        /**
         * 构建kafka的spout
         */
        TridentKafkaConfig kafkaConf = new TridentKafkaConfig(new ZkHosts(
                zkHosts), // default zkPath /brokers/
                TOPIC_NAME, "hbase");
        kafkaConf.scheme = new SchemeAsMultiScheme(new StringScheme()); // default fields named "str"
        // kafkaConf.forceFromStart = true;

        OpaqueTridentKafkaSpout kafkaSpout = new OpaqueTridentKafkaSpout(
                kafkaConf);
        //////////////////////////////////////////////////

        /**
         * 构建Strom tuple与hbase表之间的映射关系，注意在storm的0.9.6的版本当中HBaseMapState.Options不支持mapMapper操作
         */
        TridentHBaseMapMapper tridentHBaseMapper = new SimpleTridentHBaseMapMapper("sum");
        List<Object> rowKey = new ArrayList<Object>();
        rowKey.add("word");
        tridentHBaseMapper.rowKey(rowKey);
        HBaseMapState.Options opts = new HBaseMapState.Options();
        opts.tableName = "wordcount2";
        opts.columnFamily = "val";
        opts.mapMapper = tridentHBaseMapper;
        org.apache.storm.trident.state.StateFactory factory = HBaseMapState.opaque(opts);
        /////////////////////////////////////////////////

        /**
         * 构建作业流,因为使用的是不透明的状态，所以最后的value存储的结果为list<事务id，当前值，上一个事务的值>
         */
        TridentTopology topology = new TridentTopology();
        topology.newStream("kafka_hbase", kafkaSpout).
                each(kafkaConf.scheme.getOutputFields(), new AddOneFunction(),new Fields("word","one")).
                groupBy(new Fields("word")).
                persistentAggregate(factory, new Fields("one"), new Sum(), new Fields("sum"));
        return topology.build();

    }

    public static void main(String[] args) throws Exception {
        Config conf = new Config();
        Map<String, String> hBaseConfigMap = new HashMap<String, String>();
        conf.put("hbconfig", hBaseConfigMap);
        StormSubmitter.submitTopology("test2Hbase", conf, buildTopology());
        Configuration hbConfig = HBaseConfiguration.create();
        System.out.println("hbase.rootdir:" + hbConfig.get("hbase.rootdir"));
        System.out.println("hbase.zookeeper.property.clientPort:" + hbConfig.get("hbase.zookeeper.property.clientPort"));
        System.out.println("hbase.zookeeper.quorum:" + hbConfig.get("hbase.zookeeper.quorum"));
        System.out.println("fs.hdfs.impl:" + hbConfig.get("fs.hdfs.impl"));
        System.out.println("test end");
    }

}
