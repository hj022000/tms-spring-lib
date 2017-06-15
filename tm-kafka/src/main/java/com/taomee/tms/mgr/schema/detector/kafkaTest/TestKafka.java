package com.taomee.tms.mgr.schema.detector.kafkaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by looper on 2017/6/6.
 */
public class TestKafka {

    public static void main(String[] args) {
        //List<String ,Integer> lists = new ArrayList<>();
        //Map<String,Integer> maps1 = new HashMap<Integer,String>();
        Map<String,Integer> maps = new HashMap<>();
        maps.put("t1",1);
        maps.put("t2",2);
        System.out.println(maps.get("t1"));
    }
}
