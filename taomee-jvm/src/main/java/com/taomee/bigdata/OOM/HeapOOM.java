package com.taomee.bigdata.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/15.
 */
public class HeapOOM {

    /**
     * jvm 参数  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> lists = new ArrayList<OOMObject>();
        while(true)
        {
            lists.add(new OOMObject());
        }
    }
}
