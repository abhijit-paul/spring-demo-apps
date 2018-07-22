package com.example.demoapp.demo;

public interface Coach  {
    public String getDailyWorkout();
    public Skill getPrimarySkill();
    public Skill getAdditionalSkill();
    public void setCoachPersonnel(CoachPersonnel coachPersonnel);
    public String getCoachPersonnelDetails();
    public void augmentSkill(Skill skill);
    public String getAugmentedSkills();
}