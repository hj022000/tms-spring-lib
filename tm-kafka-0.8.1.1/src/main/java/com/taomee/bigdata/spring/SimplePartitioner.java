package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/7.
 */
import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class SimplePartitioner implements Partitioner {
    public SimplePartitioner (VerifiableProperties props) {

    }

    public int partition(Object key, int a_numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
            partition = Integer.parseInt( stringKey.substring(offset+1)) % a_numPartitions;
        }
        return partition;
    }

}
