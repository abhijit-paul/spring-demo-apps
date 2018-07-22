package com.example.demoapp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

	public static void showDetails(Coach theCoach)	{
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getPrimarySkill().display());
		System.out.println(
			null != theCoach.getAdditionalSkill()
			? theCoach.getAdditionalSkill().display()
			: "");
		System.out.println("Coach Details: \n" + theCoach.getCoachPersonnelDetails());
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("CRICKET Details");
		SkillAbstractorCoach cricketCoach = context.getBean("cricketCoach", SkillAbstractorCoach.class);
		showDetails(cricketCoach);

		cricketCoach.augmentSkill(
			(AugmentedSkill)context.getBean("augmentedSkill", "Straight Drive")
		);
		cricketCoach.augmentSkill(
			(AugmentedSkill)context.getBean("augmentedSkill", "Hook Shot")
		);
		System.out.println(cricketCoach.getAugmentedSkills());



		System.out.println("TENNIS Details");
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		showDetails(tennisCoach);

		System.out.println("BASEBALL Details");
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		showDetails(baseballCoach);

		context.close();
	}
}
