package com.taomee.bigdata.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by looper on 2017/4/26.
 */
@Configuration
@PropertySource("classpath:/com/taomee/bigdata/spring/auto/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment environment;


    @Bean(name = "cat")
    public Cat cat()
    {
        System.out.println("name:"+environment.getProperty("name")+",age:" +Integer.parseInt(environment.getProperty("age")));
        return new Cat(environment.getProperty("name"),Integer.parseInt(environment.getProperty("age")));
    }
}
