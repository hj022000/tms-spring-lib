package com.taomee.bigdata.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by looper on 2017/4/26.
 * 设置EnableAspectJAutoProxy自动代理
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AutoConfig {
}
