package com.taomee.bigdata.spring.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by looper on 2017/4/26.
 */
@Configuration
@ComponentScan(basePackages = {"com.taomee.bigdata.spring.auto","com.taomee.bigdata.spring.spel"})
public class AutoConfig {
}
