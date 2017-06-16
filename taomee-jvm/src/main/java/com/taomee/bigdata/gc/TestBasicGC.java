package com.taomee.bigdata.gc;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/16.
 */
public class TestBasicGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * V运行时JVM参数:-XX:+UseSerialGC -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -verbose:gc -XX:SurvivorRatio=8 -Xms20M -Xmx20M -Xmn10M
     * 运行结果
     * 0.123: [GC0.123: [DefNew: 8009K->743K(9216K), 0.0121052 secs] 8009K->6887K(19456K), 0.0121434 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     Heap
     def new generation   total 9216K, used 5085K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
     eden space 8192K,  53% used [0x00000000f9a00000, 0x00000000f9e3d7f0, 0x00000000fa200000)
     from space 1024K,  72% used [0x00000000fa300000, 0x00000000fa3b9e60, 0x00000000fa400000)
     to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
     tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
     the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
     compacting perm gen  total 21248K, used 2865K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
     the space 21248K,  13% used [0x00000000fae00000, 0x00000000fb0cc658, 0x00000000fb0cc800, 0x00000000fc2c0000)
     No shared spaces configured.
     */
    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
