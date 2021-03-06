package com.taomee.bigdata.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by looper on 2017/4/26.
 */
public class Run3 {
    public static void main(String[] args) {
        //new Run2().say();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/taomee/bigdata/spring/bean.xml");
        /*Run2 run2 = (Run2) applicationContext.getBean("run2");
        *//*run2.say();
        Dessert dessert = run2.getDessert();
        Dessert dessert1 = run2.getDessert();
        System.out.println(dessert == dessert1);*//*
        Run2 run2_2 = (Run2) applicationContext.getBean("run2");
        System.out.println(run2 == run2_2);*/
        /*Cat cat = (Cat)applicationContext.getBean("cat");
        System.out.println(cat);*/
        //cat.toString();

        //*****  spring增强引入
        Performance performance = (Performance) applicationContext.getBean("singPerformance");
        performance.perform();
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performacEncore();
        //*****

       /* Audience audience = (Audience) applicationContext.getBean("audience");
        audience.applause();*/
        /*DefaultEncoreable encoreable = (DefaultEncoreable)applicationContext.getBean("defaultEncoreable");
        encoreable.performacEncore();*/


    }
}
