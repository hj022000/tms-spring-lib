package com.taomee.bigdata.nio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by looper on 2017/5/23.
 */
public class TestItero {

    public static void main(String[] args) {
        Set <String> sets = new LinkedHashSet<String>();
        /*sets.add("12");
        sets.add("13");*/
        for(int i = 0 ; i<10 ; i++)
        {
            sets.add(String.valueOf(i));
        }

        Iterator<String> iterator =sets.iterator();
        while(iterator.hasNext())
        {
            String s = iterator.next();
            System.out.print("s:" + s +"\t");
           // System.out.println("length:" );
            iterator.remove();
        }
    }
}
