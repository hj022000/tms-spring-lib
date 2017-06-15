package com.taomee.bigdata.spring;

import org.apache.kafka.clients.producer.internals.DefaultPartitioner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by looper on 2017/6/8.
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        for (String s : lists) {
            do {
                // System.out.println(10/0);
                System.out.println(s);
                if (s == "3") {
                    System.out.println(s);
                    break;
                }
                if (s == "1")
                {
                    System.out.println(s);
                    break;
                }
            } while (false);
            System.out.println("d");
           // DefaultPartitioner;
        }
    }
}
