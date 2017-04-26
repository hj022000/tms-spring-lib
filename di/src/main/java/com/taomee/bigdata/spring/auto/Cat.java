package com.taomee.bigdata.spring.auto;

import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */

public class Cat {
    private String name;
    private Integer age;


    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
