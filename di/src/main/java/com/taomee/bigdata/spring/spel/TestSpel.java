package com.taomee.bigdata.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */
@Component
public class TestSpel {
    private String name;
    private Integer age;

    public TestSpel(@Value("10") Integer age, @Value("jack") String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestSpel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
