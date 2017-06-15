package com.taomee.bigdata.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 * 环绕通知
 */
@Aspect
//@Component
public class AroundAudience {

    @Pointcut("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void performance()
    {

    }
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint)
    {
        try {
            System.out.println("Silencing call phones...");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("CALP CALP");
        } catch (Throwable throwable) {
            //throwable.printStackTrace();
            System.out.println("Demanding a refund");
        }
    }
}
