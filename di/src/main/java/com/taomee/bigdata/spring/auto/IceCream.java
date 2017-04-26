package com.taomee.bigdata.spring.auto;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/26.
 * Primary 表示设置首选bean，当出现多个歧义的bean时,
 * Qualifier("cold") 创建自定义的限定符
 */
@Component
@Qualifier("cold")
public class IceCream implements Dessert{

    public void make() {
        System.out.println("IceCream make...");
    }
}
