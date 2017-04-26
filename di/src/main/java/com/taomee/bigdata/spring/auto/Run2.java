package com.taomee.bigdata.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 */


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Run2 {

   // private AutoConfig AutoConfig = new AutoConfig();
   // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/taomee/bigdata/spring/bean.xml");
    //FileSystemXmlApplicationContext context;
    {
        //applicationContext.
        //context.start();
    }
    //Qualifier("cake")设置在自动注入的时候，将依赖的bean设置为后面字符串名称大写的类的bean
    //但是这样会导致如果你在重构类的名称的时候，会导致注入失败，因此可以在申明组件的时候，申明其名称
    @Autowired
    @Qualifier("cold")
    private Dessert dessert;


  /*  @Autowired
    public void setDessert(Dessert dessert)
    {
        this.dessert = dessert;
    }*/

    public void say()
    {
       // Dessert dessert = (Dessert) applicationContext.getBean("cake");
        dessert.make();
       // System.out.println("dessert:" + dessert);
    }
    /*public static void main(String[] args) {
       // System.out.println(new Run2);
        //System.out.println();
        new Run2().say();
    }*/

    public Dessert getDessert()
    {
        return dessert;
    }
}
