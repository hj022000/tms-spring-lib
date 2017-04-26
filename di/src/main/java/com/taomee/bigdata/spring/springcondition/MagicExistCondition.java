package com.taomee.bigdata.spring.springcondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by looper on 2017/4/26.
 * 实现Condition接口实现匹配条件
 */
public class MagicExistCondition implements Condition{

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().containsProperty("magic");
        //return false;
    }
}
