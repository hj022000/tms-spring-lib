package com.taomee.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by looper on 2017/4/27.
 */
@Configuration
@ComponentScan(basePackages = {"com.taomee.spring.web.config"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {

}
