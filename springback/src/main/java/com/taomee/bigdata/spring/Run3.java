package com.taomee.bigdata.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

/**
 * Created by looper on 2017/4/26.
 */
public class Run3 {
    public static void main(String[] args) {
        //new Run2().say();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/taomee/bigdata/spring/bean2.xml");

       /* GPZSRepository jdbcGPZSRepository = (GPZSRepository) applicationContext.getBean("jdbcGPZSRepository");
        System.out.println(jdbcGPZSRepository.findOne(105));*/

       /* SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        System.out.println(sessionFactory);
        sessionFactory.close();*/
        LocalEntityManagerFactoryBean localEntityManagerFactoryBean =(LocalEntityManagerFactoryBean) applicationContext.getBean("entityManagerFactoryBean");
        System.out.println(localEntityManagerFactoryBean);

    }
}
