package com.taomee.bigdata.gc;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/16.
 */
public class RefCountingGC {
    public Object instance  = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigsize = new byte[2 * _1MB];

    public static void main(String[] args) {

    }
}
