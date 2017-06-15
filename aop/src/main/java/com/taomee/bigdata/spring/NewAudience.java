package com.taomee.bigdata.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */
@Component
public class NewAudience {

    @Pointcut("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void performance()
    {

    }


    @Before("performance()")
    public void silenceCellPhones()
    {
        System.out.println("Silencing cell phone");
    }


    @Before("performance()")
    public void takeSeats()
    {
        System.out.println("Taking seats");
    }


    @AfterReturning("performance()")
    public void applause()
    {
        System.out.println("CLAP CLAP CLAP");
    }


    @AfterThrowing("performance()")
    public void demandRefund()
    {
        System.out.println("Demanding a refund");
    }
}
