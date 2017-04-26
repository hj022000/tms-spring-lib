package com.taomee.bigdata.spring;

import com.taomee.bigdata.spring.day1.Apple;
import com.taomee.bigdata.spring.day1.CampactDisc;
import com.taomee.bigdata.spring.day1_1.Gtest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by looper on 2017/4/19.
 */
public class Run {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/taomee/bigdata/spring/bean.xml");
        /*CampactDisc campactDisc = (CampactDisc) applicationContext.getBean("sgtPeppers");
        campactDisc.play();
        Gtest gg = (Gtest) applicationContext.getBean("gtest");
        gg.test1();*/
        Apple apple = (Apple) applicationContext.getBean("apple");
        System.out.println(apple.weight());
       // System.out.println(System.getProperty("java.class.path"));

    }
}
