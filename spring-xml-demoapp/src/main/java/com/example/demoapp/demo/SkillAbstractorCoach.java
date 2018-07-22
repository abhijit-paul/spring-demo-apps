package com.example.demoapp.demo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class SkillAbstractorCoach implements Coach    {
    private Skill primarySkill;
    private Skill additionalSkill;
    private ArrayList<Skill> augmentedSkills;
    private String dailyWorkout;
    private CoachPersonnel coachPersonnel;

    public void printStartTime() {
        System.out.println(
            "STARTING TIME: "+
            DateFormat.getTimeInstance().format(new Date())
        );
    }

    public void printClosingTime()  {
        System.out.println(
            "CLOSING TIME: "+
            DateFormat.getTimeInstance().format(new Date())
        );
    }

    public SkillAbstractorCoach(Skill skill)  {
        this.primarySkill = skill;
    }

    public void setAdditionalSkill(Skill skill)  {
        this.additionalSkill = skill;
    }

    @Override
    public String getDailyWorkout() {
        return this.dailyWorkout;
    }

    public void setDailyWorkout(String dailyWorkout)   {
        this.dailyWorkout = dailyWorkout;
    }

    @Override
    public Skill getPrimarySkill() {
        return this.primarySkill;
    }

    @Override
    public Skill getAdditionalSkill()  {
        if(null != this.additionalSkill)    {
            return this.additionalSkill;
        }
        else {
            return null;
        }
    }

    @Override
    public void setCoachPersonnel(CoachPersonnel coachPersonnel)    {
        this.coachPersonnel = coachPersonnel;
    }

    @Override
    public String getCoachPersonnelDetails()  {
        if(null == coachPersonnel)  {
            return null;
        }
        return String.join(
            " ,\n",
            String.join(": ", "Name", coachPersonnel.getName()),
            String.join(": ", "Address",
                coachPersonnel.getHouseNumber() + " " + coachPersonnel.getHouseStreet())
        );
    }

    public void augmentSkill(Skill skill)   {
        if(null == augmentedSkills) {
            augmentedSkills = new ArrayList<>();
        }
        augmentedSkills.add(skill);
    }

    public String getAugmentedSkills()  {
        if (null == augmentedSkills) {
            return null;
        }
        StringBuilder allSkillDetails = new StringBuilder("Augmented Skills: ");
        for(Skill skill : augmentedSkills)   {
            allSkillDetails.append(skill.display()+", ");
        }
        return allSkillDetails.toString();
    }
}