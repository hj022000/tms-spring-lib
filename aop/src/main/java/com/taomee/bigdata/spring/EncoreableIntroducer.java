package com.taomee.bigdata.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */
@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value="com.taomee.bigdata.spring.Performance+",defaultImpl =DefaultEncoreable.class )
    public static Encoreable encoreable;
}
