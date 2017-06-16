package com.taomee.bigdata.gc;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/16.
 */
public class TestGC {
    /**
     *  VM参数:-XX:+PrintGCTimeStamps -XX:+PrintGCDetails
     *  设置jvm参数-XX:+UseSerialGC -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("1111");
        System.gc();
    }
}
