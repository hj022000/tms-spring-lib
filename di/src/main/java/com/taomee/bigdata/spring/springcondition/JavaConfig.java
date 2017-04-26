package com.taomee.bigdata.spring.springcondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by looper on 2017/4/26.
 */
@Configuration
public class JavaConfig {

    /**
     * 通过加入 Conditional注解实现条件注入，下面只要当系统环境中存在magic环境变量的时候，该bean才会被创建
     * @return
     */
    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean()
    {
        return new MagicBean();
    }
}
