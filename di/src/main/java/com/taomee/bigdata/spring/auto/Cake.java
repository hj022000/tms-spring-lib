package com.taomee.bigdata.spring.auto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */
@Component
@Primary
public class Cake implements Dessert{

    public void make() {
        System.out.println("Cake make..." );
    }
}
