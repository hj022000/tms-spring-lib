package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/7.
 * 运行代码
 */
public class Run {
    public static void main(String[] args) {
        V8_Producer producer = new V8_Producer("my-topic2");
        producer.start();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产者开始生产...");

        V8_Consumer consumer = new V8_Consumer("my-topic2");
        consumer.start();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者开始消费...");
    }
}
