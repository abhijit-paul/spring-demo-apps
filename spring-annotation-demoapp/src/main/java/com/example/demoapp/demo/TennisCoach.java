package com.example.demoapp.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach extends SkillAbstractorCoach   {

    @Autowired
    public TennisCoach(@Qualifier("forehandSkill") Skill skill) {
        super(skill);
    }

    @Override
    @Autowired
    @Value("Do 10 Bench split squats")
    public void setDailyWorkout(String dailyWorkout) {
        super.setDailyWorkout(dailyWorkout);
    }

    @Override
    @Autowired
    @Qualifier("tennisCoachPersonnel")
    public void setCoachPersonnel(CoachPersonnel coachPersonnel) {
        super.setCoachPersonnel(coachPersonnel);
    }
}