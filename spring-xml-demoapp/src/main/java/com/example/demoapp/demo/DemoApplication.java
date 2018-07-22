package com.example.demoapp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getPrimarySkill().display());
		System.out.println(
			null != theCoach.getAdditionalSkill()
			? theCoach.getAdditionalSkill().display()
			: "");
		System.out.println(theCoach.getCoachPersonnelDetails());

		theCoach.augmentSkill(
			(AugmentedSkill)context.getBean("augmentedSkill", "Straight Drive")
		);
		theCoach.augmentSkill(
			(AugmentedSkill)context.getBean("augmentedSkill", "Hook Shot")
		);

		System.out.println(theCoach.getAugmentedSkills());

		context.close();
		//SpringApplication.run(DemoApplication.class, args);
	}
}
