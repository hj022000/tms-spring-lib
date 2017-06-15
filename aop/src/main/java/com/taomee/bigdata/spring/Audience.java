package com.taomee.bigdata.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by looper on 2017/4/26.
 */
//@Component
@Aspect
public class Audience {

    @Before("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void silenceCellPhones()
    {
        System.out.println("Silencing cell phone");
    }

    @Before("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void takeSeats()
    {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void applause()
    {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("execution (** com.taomee.bigdata.spring.Performance.perform(..))")
    public void demandRefund()
    {
        System.out.println("Demanding a refund");
    }

}
