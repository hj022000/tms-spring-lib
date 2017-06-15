package com.taomee.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by looper on 2017/4/27.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.taomee.spring.web.viewbean")//启动组件扫描
public class WebConfig extends WebMvcConfigurerAdapter{

    /**
     * 配置JSP视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //构造前缀和后缀，构成新的url
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源的处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }
}
