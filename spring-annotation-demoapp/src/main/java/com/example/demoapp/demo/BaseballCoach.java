package com.example.demoapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach extends SkillAbstractorCoach  {

    @Autowired
    public BaseballCoach(@Qualifier("pitchingSkill") Skill skill)  {
        super(skill);
    }

    @Override
    @Autowired
    @Value("Spend 30 minutes on pitching practice")
    public void setDailyWorkout(String dailyWorkout) {
        super.setDailyWorkout(dailyWorkout);
    }

    @Override
    @Autowired
    @Qualifier("hittingSkill")
    public void setAdditionalSkill(Skill skill) {
        super.setAdditionalSkill(skill);
    }
}