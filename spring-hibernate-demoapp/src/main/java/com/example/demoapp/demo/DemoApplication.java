package com.example.demoapp.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(
	exclude={
		JpaRepositoriesAutoConfiguration.class,
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
	})
public class DemoApplication {

	public static void testConnection()	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try	{
			System.out.println("Connecting...");
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Conn success");
			myConn.close();
		}
		catch (Exception exc)	{
			exc.printStackTrace();
		}
	}

	public static void main(String[] args) {
		testConnection();
		SpringApplication.run(DemoApplication.class, args);
	}
}
