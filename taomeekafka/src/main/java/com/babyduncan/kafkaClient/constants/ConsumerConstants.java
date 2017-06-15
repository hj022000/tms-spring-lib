package com.babyduncan.kafkaClient.constants;

/**
 * Created by looper on 2017/6/6.
 */
public final class ConsumerConstants {

    private ConsumerConstants() {/**/}


    public static final String[][] DEFAULT_CONFIG = new String[][]{
            {"zk.sessiontimeout.ms", "400"},
            {"zk.connectiontimeout.ms", "6000"},
            {"zk.synctime.ms", "200"},
            {"socket.timeout.ms", "30000"},
            {"socket.buffersize", String.valueOf(64 * 1024)},
            {"fetch.size", String.valueOf(300 * 1024)},
            {"queuedchunks.max", "100"},
            {"autocommit.enable", "true"},
            {"autocommit.interval.ms", "10000"},
            {"autooffset.reset", "smallest"},
            {"rebalance.retries.max", "10"},
            {"groupid", "test_group"}
    };

    public static final String[][] FIXED_CONFIG = new String[][]{
            {"consumer.timeout.ms", "-1"}
    };
}
