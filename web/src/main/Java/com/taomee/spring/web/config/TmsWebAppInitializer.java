package com.taomee.spring.web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by looper on 2017/4/27.
 */

public class TmsWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
