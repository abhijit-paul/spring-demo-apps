package com.example.demoapp.demo;

import com.example.demoapp.demo.model.StudentDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@MockBean
	private StudentDAO dao;

	@TestConfiguration
	static class AppTestConfig {
		return new sessionFactory();
	}

	@Test
	public void contextLoads() {
	}

}
