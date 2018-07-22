package com.example.demoapp.demo;

import java.text.DateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach extends SkillAbstractorCoach  {


    @PostConstruct
    public void printStartTime() {
        System.out.println(
            "STARTING TIME: "+
            DateFormat.getTimeInstance().format(new Date())
        );
    }

    @PreDestroy
    public void printClosingTime()  {
        System.out.println(
            "CLOSING TIME: "+
            DateFormat.getTimeInstance().format(new Date())
        );
    }

    @Autowired
    public CricketCoach(@Qualifier("bowlingSkill") Skill skill)    {
        super(skill);
    }

    @Override
    @Autowired
    @Qualifier("battingSkill")
    public void setAdditionalSkill(Skill skill) {
        super.setAdditionalSkill(skill);
    }

    @Override
    @Autowired
    @Value("Run 5 kms at 8km/h")
    public void setDailyWorkout(String dailyWorkout) {
        super.setDailyWorkout(dailyWorkout);
    }


    @Override
    @Autowired
    @Qualifier("cricketCoachPersonnel")
    public void setCoachPersonnel(CoachPersonnel coachPersonnel) {
        super.setCoachPersonnel(coachPersonnel);
    }

    public CoachPersonnel getCoachPersonnel() {
        return super.getCoachPersonnel();
    }
}