package com.taomee.bigdata.spring;



import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by looper on 2017/6/8.
 */
public class ServerInfoPartitioner implements Partitioner{

    /**
     * 返回分区
     * @param topic
     * @param key
     * @param keyBytes
     * @param value
     * @param valueBytes
     * @param cluster
     * @return
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        //参考系统默认的DefaultPartitioner获取topic 的partition num的代码实现
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();

        //serverId 对topic的partition取余获取消息被插入到哪个partition
        String serverId =(String) key;
        return Integer.valueOf(serverId) % numPartitions;

    }
    /**
     *
     * @param configs
     */
    @Override
    public void configure(Map<String, ?> configs) {
        //此方法获取的是前面prop文件当中的配置信息，获取不到系统的配置信息
        // partitions_nums =configs.get("num.partitions").toString();
    }

    @Override
    public void close() {
    }

}
