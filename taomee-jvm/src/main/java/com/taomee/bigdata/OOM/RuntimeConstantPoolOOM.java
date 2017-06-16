package com.taomee.bigdata.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/15.
 */
public class RuntimeConstantPoolOOM {
    /**
     * VM参数: -XX:PermSize=10M -XX:MaxPermSize=10M
     * jdk1.6 Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
     * jdk1.7 因为常量池被从方法区那边移除了。
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true)
        {
            list.add(String.valueOf(i++).intern());
        }
    }
}
