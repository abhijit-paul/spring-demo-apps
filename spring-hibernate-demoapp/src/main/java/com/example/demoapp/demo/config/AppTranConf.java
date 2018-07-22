package com.example.demoapp.demo.config;
import java.util.Properties;

import javax.sql.DataSource;

import com.example.demoapp.demo.model.StudentDAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.example.demoapp")
@EnableTransactionManagement
public class AppTranConf    {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factBean = new LocalSessionFactoryBean();
        factBean.setDataSource(dataSource());
        factBean.setHibernateProperties(hibernateProperties());
        factBean.setAnnotatedPackages(StudentDAO.class.getPackage().getName());
        return factBean;
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
    public Properties hibernateProperties()   {
        Properties p =  new Properties();
        p.put("hibernate.hbm2ddl.auto", "update");
        p.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        p.put("hibernate.show_sql", "true");
        return p;
    }

    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

}