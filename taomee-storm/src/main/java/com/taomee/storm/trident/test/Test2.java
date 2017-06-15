package com.taomee.storm.trident.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by looper on 2017/6/14.
 */
public class Test2 {
    public static void main(String[] args) {
       /* List<String> lists = new ArrayList<String>();
        lists.add("");
        for(String s:lists)
        {
            System.out.println(s.length());
        }*/
        List<String> fakeOpValues = new ArrayList<String>();
        //System.out.println(fakeOpValues.size());
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("1","2");
        for(String s:fakeOpValues)
        {
           // System.out.println(s);
            String s2 = maps.get(s);
            System.out.println(s2.trim().length());

        }

    }
}
