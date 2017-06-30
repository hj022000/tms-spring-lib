package com.taomee.bigdata.spring;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/6/29.
 */
public class AddOneFunction extends BaseFunction {
    public void execute(TridentTuple tuple, TridentCollector collector) {
        String word =(String)tuple.get(0);
        List<Object> one = new ArrayList<Object>();
        one.add(word);
        one.add(1l);
        collector.emit(one);
    }
}
