package com.taomee.bigdata.spring;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by looper on 2017/4/28.
 */
public class Test1 {

    public static void main(String[] args) {
        /*Time time = new Time(System.currentTimeMillis());
        System.out.println(time);*/
       /* Date date = new Date(System.currentTimeMillis());
        System.out.println(date.getTime());*/
        Date date = new Date(System.currentTimeMillis());
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
       // System.out.println(date);
    }
}
