package com.taomee.bigdata.spring;

import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */
@Component
public class SingPerformance implements Performance{
    public void perform() {
        System.out.println("Sing performance play...");
    }
}
