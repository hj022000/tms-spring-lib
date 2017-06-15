package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/7.
 */
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerTest implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;

    public ConsumerTest(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }

    public void run() {
        System.out.println("m_stream:" + m_stream);
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
      //  boolean it =
        //System.out.println("it");
        System.out.println("it:" +it);
        boolean hashNext = it.hasNext();
        System.out.println("hashNext:" + hashNext);
        while (hashNext) {
            System.out.println("Thread " + m_threadNumber + ": " + new String(it.next().message()));
            System.out.println("t...");
            hashNext = it.hasNext();
        }
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}