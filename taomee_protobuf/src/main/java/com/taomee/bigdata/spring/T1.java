package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/6/2.
 */
public class T1 {

    public static void main(String[] args) {
       /* int a = 1;
        int b = 1;
        System.out.println(a == b);

        int a1 = 10000;
        int b1 = 10000;
        System.out.println(a1 == b1);*/

        Integer a = 1;
        Integer b = 1;

        Integer a1 = 127;
        Integer b1 = 127;

        Integer c1 = 128;
        Integer d1 = 128;
        System.out.println(a == b);
        System.out.println(a1 == b1);
        System.out.println(c1 == c1);

        System.out.println("------------");
        String s1 = new String("d");
        String s2 = new String("d");
        String s3 = new String("d").intern();
        String s4 = new String("d").intern();

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);

    }
}
