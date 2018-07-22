package com.example.demoapp.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.example.demoapp.demo")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class DemoApplicationTransactionConfig   {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();
        sessionBean.setDataSource(dataSource());
        sessionBean.setPackagesToScan("com.example.demoapp.demo.model");
        sessionBean.setHibernateProperties(properties());
        return sessionBean;
    }

    @Bean
    public DataSource dataSource()  {
        return new DriverManagerDataSource(
            "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false",
            "hbstudent",
            "hbstudent"
        );
    }

    @Bean
    public Properties properties()  {
        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager()  {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}