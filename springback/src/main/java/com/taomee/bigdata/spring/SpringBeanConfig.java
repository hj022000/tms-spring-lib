package com.taomee.bigdata.spring;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by looper on 2017/4/28.
 */

@Configuration
@ComponentScan
public class SpringBeanConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://10.1.1.60:3306/db_td_config");
        ds.setUsername("root");
        ds.setPassword("pwd@60");
        return ds;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    //申明SessionFactoryBean，看下需要导入bean的依赖:hibernate4
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
    {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        //sfb.
        Properties properties = new Properties();
        properties.setProperty("dialect","org.hibernate.dialect.MySQLDialect");
        sfb.setHibernateProperties(properties);
        return sfb;
    }

   // public LocalEnti
    @Bean(name = "entityManagerFactoryBean")
    public LocalEntityManagerFactoryBean entityManagerFactoryBean()
    {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("taomee");
        return emfb;
    }
}
